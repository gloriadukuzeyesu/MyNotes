# **OOP**

**OOP** stands for **O**bject **O**riented **P**rogramming. 

=> creating objects that have data and methods. 

=> Procedure programming is about creating methods that perform operations on the data. 

=> 

Advantages

*  OOP is faster and easier to execute
* OOP provides clear structure of the program
* OOP helps to keep java program `DRY` Don't Repeat Yourself, easier to read, modidy and debug
* OOP allows to create full reusable applications with less code and shorter development time.



5 OOP Principles

1. Class and objects
2. Abstraction
3. Encapsulation 
4. Inheritance
5. Polymorphism ( static and dynamic)

## 1. Class and objects

**A class is a template for the object and object is a instance of a class**. For example, a class called Fruit and instances would be banana, avocado, apples. 

When an object is created, it inherits all the variables and methods for the class. 

## **A constuctor**

* a constructor is a special method that is used to initialize an object.  
* match the class name and has no return type. It is a void method



## **Java modifiers**

* ### class

1. Public : means a class is accessible in another class
2. Default: means a class is only accessible by the classes in the same package. 

* Modifiers, attributes

1. public: The code is accessible for all classes
2. default : The code is only accessible in the same package. This is used when you don't specify a modifier.
3. Private : The code is only accessible within the declared class
4. Protected: The code is accessible in the same package and **subclasses**.

### **No Accible modifers**

| Modifier     | Description                                                  |
| ------------ | ------------------------------------------------------------ |
| final        | attributes and methods can no be overriden or modified       |
| static       | attributes and methods belongs to class not the object       |
| abstract     | can only be used in absrct class. the method has no body. Example: **abstract void run();** |
| transient    | Attributes and methods are skipped when serializing the object containing them |
| synchronized | Methods can only be accessed by one thread at a time         |
| Volatile     | The value of an attribute is not cached thread-locally, and is always read from the "main memory" |



2. ## Abstraction 

The process of hiding certain details and showing only essential information to the user.

The `abstract` keyword is a non-access modifier, used for classes and methods:

- **Abstract class:** is a restricted class that cannot be used to create objects (to access it, it must be inherited from another class).
- **Abstract method:** can only be used in an abstract class, and it does not have a body. The body is provided by the subclass (inherited from).

#### When and why to use abastract class

* To achieve security - hide certain details and only show the important details of an object.

```java
abstract class Animal{
  abstract void makeSound(); // abstract method with no body
  void sleep() { // regular method. 
		System.out.println("Zzz");
  }
}

class Chicken extends Animal {
  void makeSound() {
    System.out.println("kwekwe");
  }
}

class Main {
  public static void main(String[] args) {
    Chicken myChicken = new Chicken(); // Create a Pig object
    myChicken.makeSound(); // outputs : kwekwe
    myChicken.sleep(); // Zzz
    Animal animal = new Animal();  // will generate an error. 
  }
}
```



## 3. Encapsulation

Encapsulation is a means of binding data variables and methods together in a class. Only objects of the class can then be allowed to access these entities. This is known as data hiding and helps in the insulation of data.

To achieve this, you must:

- declare class variables/attributes as `private`
- provide public **get** and **set** methods to access and update the value of a `private` variable

```java
public class Animals {
  private String name; 
  private int age; 
  Animals() {}; 
  
  public String getName(){
    returns name; 
  }
  public setName(String newName){
    name = newName; 
  }
  public int getAge() {
    return age; 
  }
  public setAge(int newAge) {
    age = newAge; 
  }
}
```



## 4. Inheritance

##### **Single, Multilevel, Hierarchical, and Multiple**

Inheritance is the process by which one class inherits the functions and properties of another class. The main function of inheritance is the reusability of code. Each subclass only has to define its features. The rest of the features can be derived directly from the parent class.

* **single** : parent  -   parent-child relationship where a child class extends the parent class features. `Class Y extends Class X.`

* **Multilevel**: Refers to a parent-child relationship where a child class extends another child’s class. `Class Y extends Class X. Class Z extends Class Y.`

* **Hierarchical** : This refers to a parent-child relationship where several child classes extend one class. `Class Y extends Class X, and Class Z extends Class X.`

* **Multiple**: Refers to a parent-child relationship where one child class is extending from two or more parent classes. 

  JAVA does not support this inheritance.

```java

class Vehicle {
    protected String make = "Ford"; // protect keyword allows field to be accessed by sub classes. 
    Vehicle(){};
    void honk(){
        System.out.println("honk honk from parent Vehicle");
    }
}

class Car extends Vehicle {
    Car(){};
    void MyName() {
        System.out.println("I am ford focus");
    }

}

public static main() {
  Car car1 = new Car(); // car object
  String name = car1.make; // will return ford from parent class
  System.out.println(name);
  car1.honk(); // Call the honk() method (from the Vehicle class) on the car object
  car1.MyName();  // call MyName() method from Car object 
}
```



## 5. Polymorphism 

It means many forms. It is occurs when we have many classes that are related to each other by inheritance. It allows to perform single action in different ways. 

```java

class CarModels {
    protected String make = "Ford";
    CarModels(){};
    void honk(){
        System.out.println("honk honk from parent Vehicle");
    }
}

class Toyota extends CarModels {
    Toyota(){};
    void MyName() {
        System.out.println("I am ford focus");
    }
    void honk() {
        System.out.println("Totoya honks honks");
    }

}

class Kia extends CarModels {
    void  honk() {
        System.out.println("Kia honks honks");
    }

}
```



