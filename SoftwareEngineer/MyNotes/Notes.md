# **Good Software practices** 

**Refresh about c++**

```c++
std::cerr vs std::cout
  // use std::cerr when you have errors, or exceptions. it is not buffered 
```

The zeroth th of the program is always the name of the program. 

you can direct both `cerr` and `cout` to the file or they can be printed on the screen. 

If you have errors, use `cerr`



### **for Strings.** 

```c++
#include <string> 
int main () {
  std::string greetings = "hello"; 
  // you mus#include <string>  #include <string>  
  char* greetiningPtr = (char *)"hi"; // always cast to char whenever you are using pointer
  if( greeting == "hello")
        cout<<"okay for string" << endl;
    if (strcmp(greetiningPtr, "hi"))
        cout << " okay for pointer" << endl;
 
}
```



### Writing c++

* If you write two files example.cpp 

* Use terminal, here are the prompt 

  ```c++
  c++ example.cpp - o example.cpp
  ./example
  ```

  ### Header files 

  They are only for declarations

* ### NOTES 

  ```c++
  - c is to compile the sources files and generate objects files while -o is used to generate the binary files 
  ```

  

If you have many files. In order to compile them use gmake for automatic build 

* gmake will use the make files 

* nmake  for window 

* rember make file doesn't have extension 

  

```c++
Make progam will create the o files if not find // where program is the name of the progam 
  Make clean  // deletes all the .o file s
```

Vim Cheat chat 

* open a file 

  ​	`vim file_name`

* edit a file, press `i` 
* append a text, press `a` 
* press `esc` to go back 
* type `:w` and press enter 
* Exit vim and discard changes made by typing `:q!` and press enter 

* use `:wq` to save changes and quit vim 

* `v` to select

* `y` to copy

* `d` to cut

  





```
program: main.o Caps.o Clothing.o Pants.o
        c++ main.o Caps.o Clothing.o Pants.o -o program
main.o: main.cpp
        c++ -c main.cpp
Caps.o: Caps.cpp Caps.h
        c++ -c Caps.cpp
Clothing.o: Clothing.cpp Clothing.h
        c++ -c Clothing.cpp
Pants.o: Pants.cpp Pants.h
        c++ -c Pants.cpp

build: program
clean:
        rm -f *.o program
```



NOTES

* C++ supports multiple inheritance but java can't. Java supports multiple interface

* In java if we don't want a function to be overweritten we use keyword **final**

*  Class is like a struct but the struct we don't worry about the public or private keyword 

* You should use a star before an object in c++

* You can create an object using pointers in C++ and use `->` not `.` to access member variables and methods

  ```c+
  posn *obj1 = new pos(2,3); // created an object using a pointer
  // to access variable we use a dot -> 
  obj1 -> x 
  ```

  * when used a reference, instead of pointer we use `.` 

* Keyword `virtual`  to achieve polymorphism in c++. It is the same as the `@override` keyword in java. But virtual is used on the parent declaration meaning it will be overridden in derived class. 

* a class that has at least one virtual method which means it is a pure method, that class means it is an abstract class. Same as interface class in java

  ```c++
  class Shape{ // abstrac class
   
    virtual getArea() = 0 // virtual method. 
  
  }
  ```

  if we don't use keyword `virtual` the method will not be overwrttien by children's method. 



## Working on Project Alone

* Save on Folder 
* Use Drop Box 

### Working On project in Team 

* Recommended using version control (source control) 



Steps to create local repo 

1. `git init`  
2. `git add . ` this will add the file to the staging area
3. `git commit -m`  
4. to go back on the version you want. You use `git checkout ID` 
5. If you delete a file on the working area, you can use `git reset --hard` this will restore the file from the local repository 
6. if you do `git add .`  and `git commit -m` before `git reset --hard` , the computer will assume you deleted that on purpose 

* Adding new branch `git branch <nameOfBranch>` 

* `git checkout <nameOfBranch>`

* Switchingb between branckes. ` git checkout -b <Name of branch> ` // create an new branch and switch to it right away 

* `git branch` will display all the branches, and the highlighted one is the one active. 

* `git merge --squash ` // squashing all your merge together

  

### Good Git Practices

* The main branch of your Git repository is for communication code 
* A commit on the main branch should generally be working version 

  * When working on group. But everyone has their own file. You need to `pull --rebase` to get the updated remote file that has been pushed by other party and then do `git push`
  * When working on the same project and editing, do git `pull rebase` 
  * to synchornize the local and the remote repo, `get fetch` and `get reset` works the same. 

## Testing

Testing is very important 

### Testing principle

* Systematic 
  * Have a plan: You can't test every single inputs, but you can have many types of different data types
  * 
* Early and often 



### Testing frameworks in C++ 

* CPP unit 
* Google test
* Catch2 .  It differs with google test 



#### We will use Catch2 

1. We have only one header file 
2. Minimal steps to perfom testing 
3. Assertions 

When testing: 

* test all edge cases 
* tests extrenes 

```c++
//to use catch testing to the following steps in main.cpp
#define CATCH_CONFIG_RUNNER 
#include "catch.h"

int main () {
  catch::Search().run(argc, argv) // this should be in the same file 
}

//your cpp file containing tests 
#include "catch.h"
int binarySearch() {
  implement the method as normal 
}
// include yours tests in Test_Case(). TEST_CASE is a keyword 
TEST_Case("<Search element in array/ object of the test>"){
  // write the test cases. 
}
```

require stops when the tests fails while CHECK will proceeed whenever if the test fails 



It is recommended to use sections when testing. 

* if you have a global variable, it will be taken as it is even if it is modified inside in one section or in a different section 



## SYSTEMATIC Programming 

Better approach for writing programs

* write an description about the program 
* Process of designing a program 

The design process



### **Debugging**

Examples of new git commands

`git diff`  : to see the changes made 

`git bisect` : use binary searcg to find the commit that introduced a by 

`git log` : shows commit logs. Commits that are reachable 

Use the tool `git bisect` 

Step: 

```java
$ git bisect start
$ git bisect bad        # Git assumes you mean HEAD by default
$ git bisect good <ref> # specify a tag or commit ID for <ref>
```

Git checks out the commit in the middle and waits for you to declare either:

```java
$ git bisect good
## or
$ git bisect bad
```

Then the bisect tool repeats checking out the commit halfway between good and bad commits until you tell it:

```bash
$ git bisect reset
```

### **Debugging Strategies** 

1. Problem Simplification 

2. Print statements. It might no be effective in some areas. 

3. Use Debuggers. 

   

### Tools to debug 

1. ## LLDB

   Keyword workd to use

   * `bt`  show what is on my call stack 
   * `fr` to examine frame
   * `run` to run the program 
   * `list` 
   * `s` to step over 
   * `b` 
   * Add breakpoints: 
   * `fr`
   * `breakpoint delete`

2. ### Use Sanitize tool 

   * for memory heap

   * index out of bounds error 

   * memory leaks 

   * invalid 

   * Stack and gloabal 

     ```java
     c++ array.cpp -g -fsanitize=address -o pro
     // then run 
     ./pro
       //you should see all the errors
     ```

     

     HW 3 . Qs3 continuation
     
     ```java
     class Expression {
     public:
         virtual Expression *subst(std::string str, Expression *expr) = 0;
     };
     
     class Number : public Expression {
     public:
         int value_;
     
         Number(int value);
         bool equals(Expression *expression);
         Expression *subst(std::string str, Expression *expr);
     };
     
     class Add : public Expression {
     public:
         Expression *lhs_;
         Expression *rhs_;
     
         Add(Expression *lhs, Expression *rhs);
         bool equals(Expression *expression);
         Expression *subst(std::string str, Expression *expr);
     };
     
     class Multiply : public Expression {
     public:
         Expression *lhs_;
         Expression *rhs_;
     
         Multiply(Expression *lhs, Expression *rhs);
         bool equals(Expression *expression);
         Expression *subst(std::string str, Expression *expr);
     };
     
     class Variable : public Expression {
     public:
         std::string string_;
     
         Variable(std::string strg);
         bool equals(Expression *expression);
         Expression *subst(std::string str, Expression *expr);
     };
     
     Expression *Number::subst(std::string str, Expression *expr) {
         return new Number(value_);
     }
     
     Expression *Add::subst(std::string str, Expression *expr) {
         return new Add(lhs_->subst(str, expr), rhs_->subst(str, expr));
     }
     
     Expression *Multiply::subst(std::string str, Expression *expr) {
         return new Multiply(lhs_->subst(str, expr), rhs_->subst(str, expr));
     }
     
     Expression *Variable::subst(std::string str, Expression *expr) {
         if (str == string_) {
             return expr;
         } else {
             return new Variable(string_);
         }
     }
     
     ```
     



## **Statement/line coverage**

There is a difference between code coverage vx Test coverage 

* Verify the extent to which the code has been executed

## GITHUB Actions

make github run the program all the time for you each time you push on gitbub

```java
name: msd // name of the program
on: 
	push: // specify branch 
jobs:
	build: 
		runs-on: macos-latest
    steps:
			-names: Checkout v1
        users: actions/checkout@v1
      -name: 
```

`git pull -- rebase` => updates the local repo with the local repo



## TEST Automation

* 

## **Design Patterns**

* **Creation** patterns: how you create object
* **Structural** patterns: about how different objects can combine to form a systems
* **Behavioral**: How you organize code  or how methods can be implemented

1. ### **Creation Pattern**

   * Singleton Class
   * Builder Pattern:helps in minimizing the number of parameters in the constructor and thus there is no need to pass in
   * Facade Pattern: Collecting a systems all together
   * Observer: 
   * Visitor Pattern



## **Optimization**

* Solve problems that needs to be solved
* Design classes and routines. This steps you would consider choosing the best data structures whihc is necessary. Ex: Choosing Quick sort, or merge sort, or binary search. Dedending on your needs. 



Main 3 topics

1. Code motion: moving expression from place to place 
2. Strength reduction 
3. Sharing common results (it involves elimination )

# Agile

Technique used in Real world for team to collaborate. 



## The scrum team

* The product owner 

  Fork means creating instacne of the repo

  
