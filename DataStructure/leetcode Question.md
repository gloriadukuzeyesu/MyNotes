# Leetcode Exercises 



## Set mismatch

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



## 2418. Sort the People

You are given an array of strings `names`, and an array `heights` that consists of **distinct** positive integers. Both arrays are of length `n`.

For each index `i`, `names[i]` and `heights[i]` denote the name and height of the `ith` person.

Return `names` *sorted in **descending** order by the people's heights*.

```java
  public String[] sortPeople(String[] names, int[] heights) {
    HashMap<Integer, String> map = new HashMap<>();
    for ( int i= 0; i < names.length; i++ ){
      map.put(heights[i], names[i]);
    }

    Arrays.sort(heights);
    String[] result = new String[heights.length];
    int index = 0;

    for (int i= heights.length-1; i>=0; i--) {
      result[index] = map.get(heights[i]);
      index++;
    }
    return result;
        
    }
```

## 205. Isomorphic strings 

Given two strings `s` and `t`, *determine if they are isomorphic*.

Two strings `s` and `t` are isomorphic if the characters in `s` can be replaced to get `t`.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

```java
public boolean isIsomorphic(String s, String t) {
         HashMap<Character, Character> hashMap = new HashMap<>();
        if(s.length() != t.length())
              return false;
        // store the chars into map and check if they map
        for ( int i=0; i < s.length(); i++ )
        {
            if( hashMap.containsKey(s.charAt(i)))
            {
                if( hashMap.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }
            else if (hashMap.containsValue(t.charAt(i)))
                    return false;
            else
                hashMap.put(s.charAt(i), t.charAt(i));
        }
        return true;
        
    }
```

## 88.Merge sorted array 

You are given two integer arrays `nums1` and `nums2`, sorted in **non-decreasing order**, and two integers `m` and `n`, representing the number of elements in `nums1` and `nums2` respectively.

**Merge** `nums1` and `nums2` into a single array sorted in **non-decreasing order**.

The final sorted array should not be returned by the function, but instead be *stored inside the array* `nums1`. To accommodate this, `nums1` has a length of `m + n`, where the first `m` elements denote the elements that should be merged, and the last `n` elements are set to `0` and should be ignored. `nums2` has a length of `n`.

```java
public void merge(int[] nums1, int m, int[] nums2, int n) {
       int pos = 0;
       for ( int i= m; i<m+n; i++){
           nums1[i] = nums2[pos];
           pos++;
       }
       Arrays.sort(nums1);
}
//notes

```

## Two sum 

Given an array of integers `nums` and an integer `target`, return *indices of the two numbers such that they add up to `target`*.

You may assume that each input would have ***exactly\* one solution**, and you may not use the *same* element twice.

You can return the answer in any order.

```java
public static int[] twoSum (int []nums, int target ){
  for ( int i =0; i< nums.length; i++ ) {
    for ( int j = i+1; j< nums.length; j++ ) {
      if(nums[j] == target - nums[i]) {
        return new int[] {i,j};
      }
    }
  }
  return null;
}
```

**Use a hashTable**. While iterating and insertion elements into the hastable, we also look back to check if current elements's complement already exists in the hash table. if it exists, we have found a solution and retun the indices immediately. *Reference: From leetcode website*

```java
public static int[] twoSum ( int [] nums, int target )
{
  Map<Integers, Integers>map = new HashMap<>();
  for ( int i=0; i<nums.length; i++ )
  {
    int complememnt = target - nums[i];
    //check if the complement is in the hashmap already
    if (map.containsKey(complement))
    {
      return new int[]{map.get(compliment), i};
    }
      map.put(nums[i], i);
  }
  return null; // return null just in case there is no findings

}
```





NOTES: 

```java
toCharArray() method converts the given string into a sequence of characters.
  
```

## 20. Valid Parentheses

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

```java
public boolean isValid(String s) {
  Stack<Character> stack = new Stack();
  Map<Character, Character> map = new HashMap<>();
  map.put('(', ')');
  map.put('[', ']');
  map.put('{', '}');
  for (char c : s.toCharArray()) {
     if (map.containsKey(c)) {
         stack.push(map.get(c));
      } else if (stack.empty() || stack.pop() != c){
           return false;
        } 
   }
   return stack.empty();
}
```



## 26. Remove Duplicates from Sorted Array

Given an integer array `nums` sorted in **non-decreasing order**, remove the duplicates [**in-place**](https://en.wikipedia.org/wiki/In-place_algorithm) such that each unique element appears only **once**. The **relative order** of the elements should be kept the **same**.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the **first part** of the array `nums`. More formally, if there are `k` elements after removing the duplicates, then the first `k` elements of `nums` should hold the final result. It does not matter what you leave beyond the first `k` elements.

Return `k` *after placing the final result in the first* `k` *slots of* `nums`.

Do **not** allocate extra space for another array. You must do this by **modifying the input array [in-place](https://en.wikipedia.org/wiki/In-place_algorithm)** with O(1) extra memory.

```java
 public int removeDuplicates(int[] nums) {
   int k = 0;
   if (nums.length == 0) return 0;
   for( int i= 1; i< nums.length; i++ ){
     if(nums[i] != nums[i-1]){
       k++;
       nums[k] = nums[i];
     }
   }
   return k+1; 
 }
```



