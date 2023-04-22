cmake_minimum_required(VERSION 3.24)
project(OpenMP)

set(CMAKE_CXX_STANDARD 17)

# Add the following line to enable OpenMP support
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -fopenmp")

add_executable(OpenMP main.cpp)
