cmake_minimum_required(VERSION 3.24)
project(LockFreeDataStructures)

set(CMAKE_CXX_STANDARD 17)

add_executable(LockFreeDataStructures main.cpp LockFree_Stack/Stack.cpp LockFree_Stack/Stack.h)
