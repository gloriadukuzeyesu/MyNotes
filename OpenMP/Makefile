CXX = /opt/homebrew/opt/llvm/bin/clang++
CFLAGS = -std=c++20
OPENMP_COMPILING = -fopenmp
OPENMP_LINKING = -lomp
OPEN_LIBRARY_PATH = -L/opt/homebrew/opt/libomp/lib

pro: main.cpp
	$(CXX) $(CFLAGS) $(OPENMP_COMPILING) $(OPEN_LIBRARY_PATH) $(OPENMP_LINKING) -o pro main.cpp

.PHONY: clean
clean:
	rm -rf *.o  pro

#CC = gcc
#CFLAGS = -Wall -Wextra -std=c99 -fopenmp
#
#project: main.cpp
#	$(CC) $(CFLAGS) -o project main.cpp
