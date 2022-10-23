---
typora-copy-images-to: ./media_Image
---

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
| `lst.addFirst("Sally")`                              | Adds element at teh beginnig of the list. `lst` is now `[Sally, Harry]` |
| `lst.getFirst()`                                     | gets the element stored at the beginning of the list; here "Sally" |
| `lst.getLast()`                                      | gets the element stored at the beginning of the list; here "Harry" |
| `String removed = lst.removedFirst()`                | Removes the first element of the list and returns it. Removed is `''Sally"` and `lst` is `[Harry]`. |
| `removelast()`                                       | Removes the last element of the list and returns it          |
| `ListIterator<String> iter = lst.listIterator()`     | provides an iterator for visiting all list elements          |



![Screen Shot 2022-10-23 at 9.59.50 AM](media_Image/Screen%20Shot%202022-10-23%20at%209.59.50%20AM.png)