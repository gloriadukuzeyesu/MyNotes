# 1. EXceptions 

## 	String comparison

 

```java
String S1 = "Hello";
String S2 = "Hello";
String S3 = new String("Hello");

System.out.println(S1 == S2); // returns true
System.out.println(S1.equals(S2)); // returns true
System.out.println("comparing S1 and S3: "+ S1.equals(S3)); // returns true

```

## Java Programming Example: Tic Tac Toe

* you need to have a plan
* Listen to the client 
* Write array of array of   variables based on the need of the client  

## Static Methods

Static is a functionn that does not have an object attached to it.  

there is no need using **this**  keyword 

It means no need to creat an object. it will be accessed by class 

* a static method is referenced by the class name and can be invoked without creating an object of class 
* In simpler terms, they are methods that exist even if no object has been constructed yet and that do not require an invocation object.
* Methods are created as static when object state has no effect on their behavior because they depend only on their own parameters.
* The most common use for static methods is to access static variables. They are accessed by the class name and a dot (.) followed by the name of a method
* They are declared with the keyword "static" when defining a method.

* When we create a function, we don't need to create an object. Because it belongs to class. 

* static methods are part of the class. No need to create object to invoke them 
* but it does not belong to an instance of that class and this method can be called without the instance or object of that class.

```java
className.methodName(); // Here, className is the name of a class.
For example:
    Student.add(); // Student is the name of class and add is a method.
```



### Static

Static means **only one of**

A static variable in a class, it means it is global variable within that class. It can be accessed with every method.  



### Error Handling 

## Exception (Error handling )

Exceptions are a way of handling unexpected conditions/errors

We use  *** throws an exceptionally ** and **catches**

**Excepitons that escape** is when we ignore the expetions and move on 



### Try/Cathc syntax 

```java
try {
  // code that might cause an exception 
}
catch (IoException e) {
  //code to handle a specific exception of type i/o exception
}
catch (FileNotFound) {
  // when a fikle is not found 
}
catch (Exception e) {
  // code to handle general exceptions  
}
catch (FileNotFound) {
  // when a fikle is not found 
}
```

`try` and `catch` go in pair 

The `try` statement allows you to define a block of code to be tested for errors while it is being executed.

The `catch` statement allows you to define a block of code to be executed, if an error occurs in the try block.

```java
try {
  // block of code to try 
}
catch (Exception_class_Name ref) {
}
```

* `try` `catch` I am trying to solve an error 

* The `finally` statement lets you execute code, after `try...catch`,

​			 	regardless of the result:

* `throw` i am trying to throw an error and ignore it 

* The `throw` statement allows you to create a custom error.
* Throws is used after the method. Write your custominzed message to print when you get the error
* you need to include try and catch to avoid your program to crush or terminate
* The JVM firstly checks whether the exception is handled or not. If exception is not handled, JVM provides a default exception handler that performs the following tasks: 
  * Prints out exception description
  * Prints the stack trace (Hierarchy of methods where the exception occurred).
  * Causes the program to terminate.

## Useful Data within an Exeptions



##  Server Refactoring 

 Refractor: taking your code and divide and put it into classes and methods. In other words split your long main() method into appropriate classes and methods. 

