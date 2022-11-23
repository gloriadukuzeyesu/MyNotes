# Inheritance and interface 

Generics in Java is relevatn to Template in c++

## Interfaces 

Interfaces is a blue print of a class. Only defining the signatures.  Designing what a clas shpuld contain

Contain methods not the implementation. It is not like a header file in c++. 



### components 

* Abstract method (public) : ( hiding the details). Just define the methods with no details 
* Constant ( final and public)
* Static methods 
* Private 



### Diff between Abstract and interface 

* types of varibales and methods 
* multiple inheritance 



```java
// syntax 
// use keyword interface to provide total abstraction 

 interface interFaceName 
{
  //method signature 
}

example: 
public interface Measurable 
{
  double getMeasure (); //no implemetation is needed. the methods of interface are automatically public 
}

```

**When to use interface**

* classes having same context but different implementation 

### Polymorhphism : Same method doing many different things 

 



### Sound Wave  Notes

* sound waves are continous functions
  * Transfer continous into finite data set
  * we have 16 bite and we need to store  array of bytes over time `byte[] data`
  * if we have 44110samples how many bytes do we need
  * 44100 samples pers second (Data rate for CDs)
  * each sample is short data type 
* if you have an array of samples and each sample is a short (2bytes)

**Short to bytes**

* Bitwise operations to put a short into a byte ( do the shiffitng). Don't worry about the sign 

```
byte num1 = 8;
byte num2 = -8; 

// 2 means with sign extession  and 3 means with no sign extesssion 

System.out.Println (num1 >> 2); //sign is conserverd 
System.out.Println (num2 >> 2); // sign is conserverd 


System.out.Println (num1 >>> 2); 
System.out.Println (num2 >>> 2);


```

**`use little Endian`** 



# Inheritance 

All class inheriting feature of other classes such as methods. Reusing the code 

It is the mechanism in java by which one class is allowed to inherit the features(fields and methods) of another class. 



Use `is a ` keyword. 

* Parent.... Base class or super class
* Child..... derivered class  or subcalss 



### examples

IOexpetion inheritis from Exception 



````java
// synatx 
public class DerivedClass extends BaseClass {
  
}
// base is a basename class or parent 
// derived is the child class 
````



## Overriding method

Modigy the way the parent class work. For example, implementing the methods inherited from parent in a different way

```java
//syntax

@override 
public void showdetail () {
  // code of block that override the instruction from the parent class
}
```

**Overloading**:  Same method name but different parametes in the same class. Means same method have same name that have different type of parameters that takes in.

```java
class Poly {
  public int multiply ( int a , int b) {return a*b; }
  public int multiply ( int a , int b, int c) {return a*b*c; }
  public double multiply ( double x , double y, double z) {return x*y*z; }
}

// the ccompiler will automatically know which one to call when you pass in paramater

class sub2 extends Poly {
  @overriding
  public int multiply ( int m, int c) {return m/c;}
}

```

  

**Overriding**  Same method signature in both super class and subclass. Means methods have the same name and the same parameter type. 

# Polymorphism 

means having different forms. Many classes that are related together by inheritance. A methods that may have different functionality. 

## Protected keyword

enables us to access private methods or public member variable from parent class to sub class



## Super 

Super.method() enable us to call the parent class versio of a methods in acse we have overridden it



## Println 



# JavaFX-UI Library

Stage, scene, and items 

to used a scene we use add.setscene 

* This library allows us to create GUI. using GUI library for java















