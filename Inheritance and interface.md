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













