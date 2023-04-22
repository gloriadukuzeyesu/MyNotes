# OpenMP 

**OpenMP** : is an API for writting multihreaded Applications. A libary for parallel programming in the SMP

* A set of compiler directic=ves and libary routines or paraller application programmers 
* Greatly simplfies writing multi threaded(MT)  programs in fortune C and C++. 
* Standardizes last 20+ years of SMP practices SMP (symmetric multi-processors, or shared-memory processors) 

## OpenMP core syntax

* Most of the constuctors in OPenMP are compiler directives

  `#pragma amp contract[clause[clause]...]`

  - Example : `#pragma amp parallel num_threads(4)`

    In this example : 

    * **parallel** means the the next component will be executed  in parallel with a team of 4 threads. 
    * num_threads indicated how many threads 

* The OpenMP functions are included in a header file called  `amp.h` 
* Most openMP* constructs apply to "stuctured block"
     * **Structured block** : is a block of one or more statements within one point of entry at the top and one 	point of the exit at the bottom.  example above: pragma is not part of c++, it is part of the OpenMP and you 
     * It is OKAY to have an exit() within the stuctured block. 

![Screen Shot 2023-04-19 at 1.26.35 PM](OpenMP%20Notes/Screen%20Shot%202023-04-19%20at%201.26.35%20PM.png)



# Compiling and running OpenMP code

1. On linux machine. They have gcc/g++ installed with openMP support.  use the `-fopenmp` flag on the command line:

   `gcc -fopenmp hellosmp.c  -o  hellosmp`

   

   ![Screen Shot 2023-04-19 at 1.32.29 PM](OpenMP%20Notes/Screen%20Shot%202023-04-19%20at%201.32.29%20PM.png)



# Compiling and running OPenMP on mac

Install a separate com



(Reference)[https://dev.to/lydiayuan/compiling-and-running-a-c-program-with-openmp-library-on-macos-3j9o]

# **References**

1. https://tildesites.bowdoin.edu/~ltoma/teaching/cs3225-GIS/fall17/Lectures/openmp.html
2. 



# Important commands

How to see a list of packages installed using HomeBrew 

* run `brew list`  // list of all packages installed my bew 
* `brew info package` // get the path of the package you want installed by brew
* 





```
while (num_threads > 0) {
        parallelStruct<int> result_parallelSumStd = parallel_sum_std(a, N, num_threads);
        parallelStruct<int> result_parallelSumCustomOpenMp= parallel_sum_omp1(a, N, num_threads);
        parallelStruct<int> result_parallelSumOPenMPBuiltIn = parallel_sum_omp_builtin(a, N, num_threads);
        std::cout << result_parallelSumStd.duration.count() << "   " << result_parallelSumCustomOpenMp.duration.count() << "   " << result_parallelSumOPenMPBuiltIn.duration.count();
        num_threads--;
    }
```



variables A= 1, B= 1, C= 1

#pragma omp parallet private(B first) firstPrivate(C)

* firstPrivate means each threads gets its own copy 
* Private means that each threads gets its own copy of B. except that B is an initialized. 
* A is initialized. 
* Shared last private, means whatever threads with - 1 ID 



Parallel means that you divide the work into different threads. 

#pragma opm paraller means creating threads. 

#pragma amp task means assigining one thread one job. 

#pragma opm taskwait means 

first private: means let every thread have its own copy. 
