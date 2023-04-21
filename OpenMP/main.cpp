#include <iostream>
#include <vector>
#include <thread>
#include <chrono>
#include <iomanip>

#include "/opt/homebrew/opt/libomp/include/omp.h"

template<typename T>
struct parallelStruct {
     T sum; // ensure adding is safe
    std::chrono::duration<double> duration;
};

template<typename T>
parallelStruct<T> parallel_sum_std(T a[], size_t N, size_t num_threads) {
    std::atomic<int> globalSum{}; // Initialize the globalSum variable
    // T globalSum;
    std::mutex sum_mutex;
    // create a struct object to return
    parallelStruct<T> resultStruct{};
    auto startTime = std::chrono::high_resolution_clock::now(); // get the start time
    // create the block length
    size_t blockLengthPerThread = (N + num_threads - 1) / num_threads; //to ensure that the block lengths are evenly distributed among the threads
    //size_t blockLengthPerThread = N / num_threads;
    // create a vector of threads and each thread computes its own chunk of sum
    std::vector<std::thread> vecOfThreads(num_threads);

    auto computingLocalSum = [&](size_t start, size_t end) {
        T localSum{};
        for (size_t i = start; i < end; i++) {
            localSum += a[i];
        }
//        std::unique_lock<std::mutex> lock (sum_mutex);
        sum_mutex.lock();
        globalSum += localSum;
        sum_mutex.unlock();
    };

    for (size_t i = 0; i < num_threads; i++) {
        size_t start = i * blockLengthPerThread;
        size_t end = std::min(start + blockLengthPerThread,N); // TODO what if the size of the array is smaller than the num_threads

        // get each thread to compute the sum
        vecOfThreads[i] = std::thread(computingLocalSum, start, end);
    }

    for (auto &thread: vecOfThreads) {
        thread.join();
    }
    auto endTime = std::chrono::high_resolution_clock::now(); // get the end time
    resultStruct.sum = globalSum;
    resultStruct.duration = endTime - startTime; // the duration the all threads together take to compute sum
    return resultStruct;
}


//NOTES PART 2
template<typename T>
parallelStruct<T> parallel_sum_omp1(T a[], size_t N, size_t num_threads) {
    std::atomic<T>globalSum{};
    parallelStruct<T>resultStruct{};

    //set up the clock
    auto startTime = std::chrono::high_resolution_clock::now();
    size_t blockLength =( N +  num_threads - 1) / num_threads;
   //  #pragma opm parallel num_threads(num_threads) //TODO where does to place this??

    for (int i = 0; i < num_threads; i++) {
   #pragma omp parallel num_threads(num_threads)
        {
            //  int tid = omp_get_thread_num();
            //  std::cout << tid << "\n";
            T localSum{};
            size_t startIndex = i * blockLength;
            size_t endIndex = startIndex + blockLength;

            //size_t endIndex = std::min(startIndex + blockLength, N);
            #pragma omp for
            for (size_t k = startIndex; k < endIndex; k++) {
                localSum += a[k];
            }
             #pragma omp critical
            // critical specifies that code is executed by one thread at a time source: stack overflow
            //  the enclosed code block will be executed by only one thread at a time, and not simultaneously executed by multiple threads.
            //  critical is often used to protect shared data from race conditions.
            globalSum += localSum;
        }

    }

    resultStruct.sum = globalSum;
    auto endTime = std::chrono::high_resolution_clock::now();
    resultStruct.duration = endTime - startTime;
    return resultStruct;
}


// PART 3 OpenMP Built-in Reduction
template<typename T>
parallelStruct<T> parallel_sum_omp_builtin(T a[], size_t N, size_t num_threads)
{
    T globalSum{};

    auto startTime = std::chrono::high_resolution_clock::now();
    size_t blockLength = N  + num_threads - 1 / num_threads;

    #pragma omp parallel for reduction(+:globalSum)
    for(int i = 0; i < num_threads; i++) {
        // T localSum{};
//        int id = omp_get_thread_num();
//        std::cout << "id " << id << "\n";
        size_t startIndex = i * blockLength;
        size_t endIndex = std::min(startIndex + blockLength, N);
        for(size_t k = startIndex; k < endIndex; k++) {
//            localSum += a[k];
            globalSum += a[k];
        }
    }
    auto endTime = std::chrono::high_resolution_clock::now();
    parallelStruct<T>resultStruct{};
    resultStruct.sum = globalSum;
    resultStruct.duration = endTime - startTime;
    return resultStruct;
}


template<typename T>
void run_experiment(parallelStruct<T> (*func)(T[], size_t, size_t), T a[], size_t N, size_t num_threads) {
   std::cout << "Running experiment with N=" << N << " and num_threads=" << num_threads << std::endl;
    auto result = func(a, N, num_threads);
    //std::cout << "Sum: " << result.sum << std::endl;
    std::cout << "Time taken: " << std::fixed << std::setprecision(6) << result.duration.count();
}

int main() {

    int NUM_EXPERIMENTS[3] = {1000, 2000, 4000};

    size_t MAX_THREADS = 16;
    //size_t N = 3000;

//    int a [N];
//    // initialize the array
//    for (int i = 0; i < N; i++) {
//        a[i] = 1;
//    }

 /*   for(int i = 1; i <= MAX_THREADS; i++) {
      //  parallelStruct<int> res = parallel_sum_std(a,N,i);
        parallelStruct<int> res1 = parallel_sum_omp_builtin(a,N,i);
        //std::cout << "thread: " << i << " STD: " << res.duration.count() << " OPM1: "<< res1.duration.count() << "\n";
        std::cout  << std::fixed << std::setprecision(6)<< res1.duration.count() << "\n";

    }*/

    for (unsigned long N : NUM_EXPERIMENTS) {
        int a [N];
        // initialize the array
        for (int i = 0; i < N; i++) {
            a[i] = 1;
        }
        std::cout << "N: " << N << "\n";
        for (int i = 1; i <= MAX_THREADS; i++) {
            parallelStruct<int> res1 = parallel_sum_std(a, N, i);

//            parallelStruct<int> res1 = parallel_sum_omp1(a,N,i);
            //std::cout << "thread: " << i << " STD: " << res.duration.count() << " OPM1: "<< res1.duration.count() << "\n";
            std::cout << std::fixed << std::setprecision(6) << res1.duration.count() << "\n";
        }
    }

   /*
    // run experiments for each function and each N value

        for (int j = 1; j <= MAX_THREADS; j++) {
            std::cout << "Using " << j << " threads" << std::endl;
//            run_experiment(parallel_sum_std, a, N, j);
//            run_experiment(parallel_sum_omp1, a, N, j);

            run_experiment(parallel_sum_omp_builtin, a, N, j);
        }*/




    return 0;
}
