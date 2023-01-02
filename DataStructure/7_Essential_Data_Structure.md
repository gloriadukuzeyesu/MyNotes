---
typora-copy-images-to: ./media_Image
---



**Data Structures** are different ways of storing data on your computer. Examples: ArrayList, Hashmap, Hashtable

**Alogarithms** are operations on different data structures and set of instructions for executing them. 

1. ArrayList
2. LinkedList
3. HashTables
4. Queque
5. Stack 
6. Trees
7. Graphs

## LinkedList

LinkedList used a sequences of nodes. Each node stores a value and a reference to the next node in a sequence. 

Pros: LinkedList allows speedy insertion and removal 

Cons: Element access can be slow 

``LinkedList<String> lst = new LinkedList<String>();``



##### LinkedList Method

| `LinkedList<String> lst = new LinkedList<String>();` | An empty list                                                |
| ---------------------------------------------------- | ------------------------------------------------------------ |
| `lst.addLast("Harry")`                               | adds element at the end of the list. same as `add()`         |
| `lst.addFirst("Sally")`                              | Adds element at the beginnig of the list. `lst` is now `[Sally, Harry]` |
| `lst.getFirst()`                                     | gets the element stored at the beginning of the list; here "Sally" |
| `lst.getLast()`                                      | gets the element stored at the beginning of the list; here "Harry" |
| `String removed = lst.removedFirst()`                | Removes the first element of the list and returns it. Removed is `''Sally"` and `lst` is `[Harry]`. |
| `removelast()`                                       | Removes the last element of the list and returns it          |
| `ListIterator<String> iter = lst.listIterator()`     | provides an iterator for visiting all list elements          |



![Screen Shot 2022-10-23 at 9.59.50 AM](media_Image/Screen%20Shot%202022-10-23%20at%209.59.50%20AM.png)

You obtain a list iterator with the listIterator method of the LinkedList class: 

`LinkedList<String> employeeNames = . . .;`

`ListIterator<String> iterator = employeeNames.listIterator();`

```java

while (iterator.hasnext()){
  String name = iterator.next();
  //do something with name
}

// a short hand use for each loop
for (String name : empoleeNames){
  //do something with name 
}
```



![Screen Shot 2022-10-23 at 10.18.23 AM](media_Image/Screen%20Shot%202022-10-23%20at%2010.18.23%20AM.png)

***NOTE:*** A linked list object holds a reference to the first node and each node holds a reference to the next node

* It is illegal to call `remove() ` twice in a row 
* Removing the last visited element, if it is the first one call `removeFirst()`, thus `remove()` position refence to previous





**RECURSION** 

A problem solving technique that is used to solved big problems into small problems by sliting the problem into small problems and solve those small problems, hence big problems. 

a way of solving a problem by having a function call itself.   

### Hashset 

A HashSet is a collection of items where every item is unique



Exercises



Question: Set mismatch

You have a set of integers `s`, which originally contains all the numbers from `1` to `n`. Unfortunately, due to some error, one of the numbers in `s` got duplicated to another number in the set, which results in **repetition of one** number and **loss of another** number.

You are given an integer array `nums` representing the data status of this set after the error.Find the number that occurs twice and the number that is missing and return *them in the form of an array*.

```java
class Solution {
   
    public  int[] findErrorNums(int[] nums) {
    int duplicate=0, missed =0;
    HashSet<Integer> set = new HashSet<>();

    // find the duplicate 
    for (int num : nums) {
        if (set.contains(num))
            duplicate = num;
        set.add(num);
    }
      // findin the missed 
    for( int i=1; i<= nums.length; i++ ){
        if (!set.contains(i)) {
            missed = i;
            break;
        }
    }

    return new int[]{duplicate, missed};
    }

}
```



## Stack 

basic principle, **last in first out.** In addition to the basic push and pop operations, the class provides three more functions of empty, search, and peek.![Screen Shot 2022-10-24 at 7.35.27 AM](media_Image/Screen%20Shot%202022-10-24%20at%207.35.27%20AM.png)

**Declaration** 

`public class Stack<E> extends Vector <E> `

how to create a Stack, import java.util.stack package and use StacK() constructor of this class. 

`Stack<E> stack = new Stack<E>;`



