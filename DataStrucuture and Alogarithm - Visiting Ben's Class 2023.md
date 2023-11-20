# Binary Search 

* Time complexity is `nlogn`
* Best case to seach in O(1),, when the element you are looking for is in the middle

With LinkedList, You can add to the end of the list without shifting

* can't do binary search on the linkedlist bcz you can't jump

# Binary Seach Tree

* All the left nodes of the subtree of the root are less than or equal to the that node.
* All right nodes of the root are greater than the node. 
* For each node, the values of the nodes on its left descendants are less. than or equal to the value of the current node.
* The values of the nodes on the right descents are greater than the current node. 

```java
Search(Node n , T Val) {
  // base case
  if(n == null) {
    return null;// not recommended to return null. Convient to return node which would be the value's parent. 
  }
  if(n.data == val) {
    return n;
  }
  // if the data is not n. 
  if(n.data > val) {
    // left 
    seach(n.left, val)
  } else {
    // right
    search(n.right, val)
  }
}
```

```java
Contains( val ) {
 node =  search( root, val);
  return node.data == val; 
}
```



```java
add(val) {
	
}
```

base case height is O(logn) woest case search is log n. Each time, we spilt the seach width into a half. 

 How would you find the minimum element in the BST

* Go all the way to the far bottom left .

How to get all element 

* Perfom in order traversal. `L--Root -- Right`
* 