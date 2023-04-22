#include <iostream>
#include <vector>
#include <thread>
#include <chrono>
#include <iomanip>
#include <atomic>
#include "/opt/homebrew/opt/libomp/include/omp.h"
#include "mutex"
//#include "omp.h"

/**
 * struct of sum and duration.
 * @tparam T
 */
template<typename T>
struct parallelStruct {
    T sum; // ensure adding is safe
    std::chrono::duration<double> duration;
};

/**
 * Parallel std
 * @tparam T template data type
 * @param a array that contains numbers to sum
 * @param N  size array
 * @param num_threads number of threads
 * @return returns a struct that contains sums and durations threads took to calculate the sum
 */
template<typename T>
parallelStruct<T> parallel_sum_std(T a[], size_t N, size_t num_threads) {
    std::atomic<T> globalSum{}; // Initialize the globalSum variable
    std::mutex sum_mutex;
    // create a struct object to return
    parallelStruct<T> resultStruct{};
    auto startTime = std::chrono::high_resolution_clock::now(); // get the start time
    size_t blockLengthPerThread = (N + num_threads - 1) / num_threads; //to ensure that the block lengths are evenly distributed among the threads
    // create a vector of threads and each thread computes its own chunk of sum
    std::vector<std::thread> vecOfThreads(num_threads);
    auto computingLocalSum = [&](size_t start, size_t end) {
        T localSum{};
        for (size_t i = start; i < end; i++) {
            localSum += a[i];
        }
        sum_mutex.lock();
        globalSum += localSum;
        sum_mutex.unlock();
    };

    for (size_t i = 0; i < num_threads; i++) {
        size_t start = i * blockLengthPerThread;
        size_t end = std::min(start + blockLengthPerThread,
                              N); // TODO what if the size of the array is smaller than the num_threads

        // get each thread to compute the sum
        vecOfThreads[i] = std::thread(computingLocalSum, start, end);
    }
    // join the threads
    for (auto &thread: vecOfThreads) {
        thread.join();
    }
    auto endTime = std::chrono::high_resolution_clock::now(); // get the end time
    resultStruct.sum = globalSum;
    resultStruct.duration = endTime - startTime; // the duration the all threads together take to compute sum
    return resultStruct;
}
/**
 * customized open mp
 * @tparam T template data type
 * @param a array that contains numbers to sum
 * @param N  size array
 * @param num_threads number of threads
 * @return returns a struct that contains sums and durations threads took to calculate the sum
 */

//NOTES PART 2
template<typename T>
parallelStruct<T> parallel_sum_omp1(T a[], size_t N, size_t num_threads) {
    std::atomic<T> globalSum;
    parallelStruct<T> resultStruct{};
    //set up the clock
    auto startTime = std::chrono::high_resolution_clock::now();
    size_t blockLength = (N + num_threads - 1) / num_threads;
    #pragma omp parallel num_threads(num_threads)
    {
        int tid = omp_get_thread_num();
        T localSum{};
        size_t startIndex = tid * blockLength;
        size_t endIndex = std::min(startIndex + blockLength, N);

        for (size_t k = startIndex; k < endIndex; k++) {
            localSum += a[k];
        }
    #pragma omp critical
        // critical specifies that code is executed by one thread at a time source: stack overflow
        //  the enclosed code block will be executed by only one thread at a time, and not simultaneously executed by multiple threads.
        //  critical is often used to protect shared data from race conditions.
        globalSum += localSum;
    }

    resultStruct.sum = globalSum;
    auto endTime = std::chrono::high_resolution_clock::now();
    resultStruct.duration = endTime - startTime;
    return resultStruct;
}

/**
 * OpenMP Built-in Reduction
 * @tparam T template data type
 * @param a array that contains numbers to sum
 * @param N  size array
 * @param num_threads number of threads
 * @return returns a struct that contains sums and durations threads took to calculate the sum
 */

// PART 3 OpenMP Built-in Reduction
template<typename T>
parallelStruct<T> parallel_sum_omp_builtin(T a[], size_t N, size_t num_threads) {
    T globalSum{}; // global sum
    auto startTime = std::chrono::high_resolution_clock::now();
    #pragma omp parallel for reduction(+:globalSum)  num_threads(num_threads)
    for (int k = 0; k < N; k++) {
        globalSum += a[k];
    }
    auto endTime = std::chrono::high_resolution_clock::now();
    parallelStruct<T> resultStruct{};
    resultStruct.sum = globalSum;
    resultStruct.duration = endTime - startTime;
    return resultStruct;
}

/**
 * test part 1
 */

void testPar1() {
    int N_Numbers[3] = {1000, 2000, 400};
    for (int j = 0; j < sizeof(N_Numbers); j++) {
        size_t N = N_Numbers[j];
        int a[N];
        for (int k = 0; k < N; k++) {
            a[k] = 1;
        }
        for (int num_threads = 0; num_threads < 16; num_threads++) {
            parallelStruct<int> result_parallelSumStd = parallel_sum_omp_builtin(a, N, num_threads);
            parallelStruct<int> result_parallelSumCustomOpenMp = parallel_sum_omp1(a, N, num_threads);
            parallelStruct<int> result_parallelSumOPenMPBuiltIn = parallel_sum_omp_builtin(a, N, num_threads);
            std::cout << std::fixed << std::setprecision(6) << num_threads << "  "
                      << result_parallelSumStd.duration.count() << "  "
                      << result_parallelSumCustomOpenMp.duration.count() << "  "
                      << result_parallelSumOPenMPBuiltIn.duration.count() << "  "
                      << "\n";
        }
    }

}
/**
 * test part 2
 */
void testPart2() {
    for (int i = 1; i < 17; i++) {
        size_t N = 1000 * i;
        int a[N];
        size_t num_threads = i;
        for (int k = 0; k < N; k++) {
            a[k] = 1;
        }
        parallelStruct<int> result_parallelSumStd = parallel_sum_omp_builtin(a, N, num_threads);
        parallelStruct<int> result_parallelSumCustomOpenMp = parallel_sum_omp1(a, N, num_threads);
        parallelStruct<int> result_parallelSumOPenMPBuiltIn = parallel_sum_omp_builtin(a, N, num_threads);
        std::cout << std::fixed << std::setprecision(6) << num_threads << "  "
                  << result_parallelSumStd.duration.count() << "  "
                  << result_parallelSumCustomOpenMp.duration.count() << "  "
                  << result_parallelSumOPenMPBuiltIn.duration.count() << "  "
                  << "\n";
    }
}

/**
 * main contains tests
 * @return
 */
int main() {
    testPar1();
    testPart2();
    return 0;
}



