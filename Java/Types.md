# Two types in Java

```java
// My notes. Conversion between Types
double d = 3.14;
int k = (int) d;  // the value of k is 3 
// cast. tell the computer that you are absolute sure of what you are doing

int m= 3;
double l= m;
System.out.println("the value of l is : " + l); // the value of l is 3.0

// Other requires a method call
String myString = "3";
int x = Integer.parseInt(myString); // casting strings is a little complicated
System.out.println("the value of x is: " + x); // the value of x is 3 
```

1. ## Primitives 

   * int

   * double

   * char

   * boolean

   * float

   * long 

   * byte

   * short

       * Values is directly in box

       * can't invole methods on them 

       * can't be null (but can use wrapper class)

         

2. ## Objects 

   Everthing else is an object 

   * String

   * Point (part of library)

   * Shape

   * FileResources

   * File

   * Scanner 

   * Class you write yourself 

     **NOTES**

     * Reference (arrow) to object
     * can invoke methods and access fields with dot
     * can be null
     * == checks if arrows point at some object 