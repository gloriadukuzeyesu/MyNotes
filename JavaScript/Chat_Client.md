## Review. Prev. Materials 

### CORS Error/ Security error 

The client are only to talk to the server that they originally requested the file from or originally talking to. Otherwise you will get CORS Error. 



### Static Variables

```java
Class Fraction{
  int nu, denm;
  Static boolean reduced;
}
// static variable are variables are shared across the instances of the class. it is not recommended to use them because you can accidentaly use them.
Fraction f1 = new Fraction( 3,4 );
Fraction f2 = new Fraction( 5,10); // if you use boolean reduced. This function boolean will be true, but not necessary supposed to be true. Here this instance f2, has a boolean as false. cz the fraction is not reduced.
```





