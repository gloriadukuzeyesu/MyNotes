# Leetcode Exercises 

## Arrays

### Set mismatch

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



### 2418. Sort the People

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

### 205. Isomorphic strings 

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

### 88.Merge sorted array 

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

### Two sum 

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

### 20. Valid Parentheses

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



### 26. Remove Duplicates from Sorted Array

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



### 189. Rotate Array

Given an array, rotate the array to the right by `k` steps, where `k` is non-negative.

```
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
```



```java
class Solution {
    public void rotate(int[] nums, int k) {
         k = k%nums.length;
        reverse( nums, 0, nums.length - 1); // reverse the whole array
        reverse ( nums, 0, k-1); // reverse the k numbers
        reverse ( nums, k , nums.length-1); // reverse the leftovers after K 
    }
	// write your own reverse fx
    public void reverse( int [] nums, int start, intn end) {
        while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
    }
}
```

### 217. Contains Duplicate

Given an integer array `nums`, return `true` if any value appears **at least twice** in the array, and return `false` if every element is distinct.

**Example 1:**

```
Input: nums = [1,2,3,1]
Output: true
```

**Example 2:**

```
Input: nums = [1,2,3,4]
Output: false
```

**Example 3:**

```
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
```

```java
class Solution {
   public boolean containsDuplicate(int[] nums) {
     Arrays.sort(nums);
     for ( int i=1; i < nums.length; i++){
       if ( nums[i] == nums[i-1]) {
         return true;}
     }
     return false;
   }
}
```



### 136. Single Number

Given a **non-empty** array of integers `nums`, every element appears *twice* except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.



### 66. Plus One

You are given a **large integer** represented as an integer array `digits`, where each `digits[i]` is the `ith` digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading `0`'s.

Increment the large integer by one and return *the resulting array of digits*.

**Example 1:**

```
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
```

**sol**

```java
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for( int i = n-1; i>=0 ; i-- ){
            if ( digits[i] != 9 ){
                digits[i]++;
                return digits;
            }else{
                digits[i] = 0;
            }
        }
        int [] resp = new int[n+1];
        resp[0] = 1;
        return resp;    
    }
}
```

```java
// another approach to reduce the space complexity is to use the while loop and get rig of the for loop

class solution {
  public int[] plusOne( int[] digits) {
    int n = digits.length;
    while ( n > = 0 ) {
      if (digits[n] != 9 ){
      digits[n]++;
      return digits;
      }
      else{
          digits[n] = 0;
       n--;
      }
    }
    int [] resp = new int[n+1];
    resp[0] = 1;
    return resp;
  }
}


```



### 283. Move Zeroes 

Given an integer array `nums`, move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.

**Note** that you must do this in-place without making a copy of the array.



**Example 1:**

```
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
```

**Example 2:**

```
Input: nums = [0]
Output: [0]
```

**sol**

```java
// requirenments: 
1. move all zeroes at the end 
2. all no-zero elements must retain their positio
3. Don't have to create a new array. modify the existing one
  
// steps 
//1. iterate over the array and if current numbers is not equal to 0 then append it to append it in front of the no zero digit 

class Solution {
    public void moveZeroes(int[] nums) {
        int nonzerodigit = 0;
        
        for ( int i= 0; i< nums.length; i++ ){
            if( nums[i] != 0 ){
                nums[nonzerodigit++] = nums[i];
            }
        }
        // now all the no zero digits are in the front of the array. fill the rest position with zeroes.
        for ( int i = nonzerodigit ; i<  nums.length; i++ ) {
            nums[i] = 0;
        }
    }
}
```

Space complexity is *O(1*) because only constant space has been used

Time complexity is *O(n)* linear complexity, The time increases as the size of inputs increases. 





### 36. Valid Sudoku

Determine if a `9 x 9` Sudoku board is valid. Only the filled cells need to be validated **according to the following rules**:

1. Each row must contain the digits `1-9` without repetition.
2. Each column must contain the digits `1-9` without repetition.
3. Each of the nine `3 x 3` sub-boxes of the grid must contain the digits `1-9` without repetition.

**Note:**

- A Sudoku board (partially filled) could be valid but is not necessarily solvable.
- Only the filled cells need to be validated according to the mentioned rules.



**Example 1:**

![img](leetcode%20Question/250px-Sudoku-by-L2G-20050714.svg.png)

```
Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
```

**Example 2:**

```
Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
```

 

**Constraints:**

- `board.length == 9`
- `board[i].length == 9`
- `board[i][j]` is a digit `1-9` or `'.'`.



```java
// HashSets only accept unique elements

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
    for (int i=0; i<9; ++i) {
        for (int j=0; j<9; ++j) {
            char number = f[i][j];
            if (number != '.')
                if (!seen.add(number + " in row " + i) ||
                    !seen.add(number + " in column " + j) ||
                    !seen.add(number + " in block " + i/3 + "-" + j/3))
                    return false;
        }
    }
    return true;
    }
}

// add() returns false if the element already exist in the set
```

![Screen Shot 2022-11-06 at 7.01.42 PM](leetcode%20Question/Screen%20Shot%202022-11-06%20at%207.01.42%20PM.png)

![Screen Shot 2022-11-06 at 7.04.16 PM](leetcode%20Question/Screen%20Shot%202022-11-06%20at%207.04.16%20PM.png)





## Strings 



### 344. Reverse String

Write a function that reverses a string. The input string is given as an array of characters `s`.

You must do this by modifying the input array [in-place](https://en.wikipedia.org/wiki/In-place_algorithm) with `O(1)` extra memory.

 

**Example 1:**

```
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
```

**Example 2:**

```
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
```

```java
// use the opposite of two pointers 
// one pointer starting from the front onother from the back and switch them up 
// incremment the first pointer and decrement the right pointer as you go
// at some point two pointers left and right will be pointing at the same character. // no need of swapping. Whether swapping or not, it will remain the same. 
// That's what inside the while loop you can also do while ( left < right ) this will work either


class Solution {
    public void reverseString(char[] s) {
        int right = s.length-1;
        int left = 0;
        char tem;
        while ( left <= right ) {
            tem = s [left];
            s [left] = s[right];
            s[right] = tem;
            left++;
            right--;
        }
       
    }
}
```



### 387. First Unique Character in a String

Given a string `s`, *find the first non-repeating character in it and return its index*. If it does not exist, return `-1`

Given a string `s`, *find the first non-repeating character in it and return its index*. If it does not exist, return `-1`.

 

**Example 1:**

```
Input: s = "leetcode"
Output: 0
```

**Example 2:**

```
Input: s = "loveleetcode"
Output: 2
```

**Example 3:**

```
Input: s = "aabb"
Output: -1
```

```java
class Solution {
    public int firstUniqChar(String s) {
        // write a hashmap. Store a char and numbe of occurence 
        // find the index with value of 1. Meaning the least occured character 
        
        HashMap<Character, Integer> count = new HashMap<>();
        int n = s.length();
        
        for ( int i= 0; i<n; i++){
            char c = s.charAt(i);
            count.put (c, count.getOrDefault(c, 0) + 1);
        }
        
        
        // find the correspoding index
        
        for ( int i= 0; i< n; i++) {
            if ( count.get(s.charAt(i)) == 1 ){
                return i;
            }
        }
        return -1; 
    }
}
```



### 7. Reverse Integer 

Given a signed 32-bit integer `x`, return `x` *with its digits reversed*. If reversing `x` causes the value to go outside the signed 32-bit integer range `[-231, 231 - 1]`, then return `0`.

**Assume the environment does not allow you to store 64-bit integers (signed or unsigned).**

 

**Example 1:**

```
Input: x = 123
Output: 321
```

**Example 2:**

```
Input: x = -123
Output: -321
```

**Example 3:**

```
Input: x = 120
Output: 21
```

 

**Constraints:**

- `-231 <= x <= 231 - 1`

```java

class Solution {
    public int reverse(int x) {
        
    int reversed  = 0;
    int pop;
    while (x != 0 ){
        pop = x % 10;
        x = x / 10;
        
        if (reversed > Integer.MAX_VALUE/10 || reversed == Integer.MAX_VALUE/10 && pop > 7 ) return 0;
        if ( reversed < Integer.MIN_VALUE/10 || reversed == Integer.MIN_VALUE/10 && pop <-8 ) return 0;
        
        reversed = (reversed * 10) + pop;
    }
    return reversed;
        
    }
}
```

## Valid Anagram



Given two strings `s` and `t`, return `true` *if* `t` *is an anagram of* `s`*, and* `false` *otherwise*.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

**Example 1:**

```
Input: s = "anagram", t = "nagaram"
Output: true
```

**Example 2:**

```
Input: s = "rat", t = "car"
Output: false
```

 

**Constraints:**

- `1 <= s.length, t.length <= 5 * 104`
- `s` and `t` consist of lowercase English letters.

```java
//NOTES: both lenghts of both strings have to be equal
// create an array of all 26 alphabets
// increment the count in the array when you see the character in string a
// decrement the count of the letter in the array when you found the character in string t
// use 'a' to find the position of the character in the array alphabetics
// in the end, the count of characters should be zero since we increment when we found the char in s and decrement when char is found t 


class Solution {
    public boolean isAnagram(String s, String t) {
        if ( s.length()!= t.length()) return false;
        
        int char_count[] = new int[26];
        
        for (int i=0; i<s.length(); i++ ) {
            char_count[s.charAt(i)-'a'] ++;
            char_count[t.charAt(i)-'a'] --;
        }
        for(int count:  char_count){
            if(count != 0) {
                return false;
            }
        }
        
        return true; 
    }
}
```





## Valid Palindrome



A phrase is a **palindrome** if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string `s`, return `true` *if it is a **palindrome**, or* `false` *otherwise*.

 

**Example 1:**

```
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
```

**Example 2:**

```
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
```

**Example 3:**

```
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
```

**Constraints:**

- `1 <= s.length <= 2 * 105`
- `s` consists only of printable ASCII characters.



```java
// convert toLowerCase
// replace all but the alhanumeric character which are letters and numbers
// then check start and end char to make sure that they are the same 
use "[^a-zA-Z0-9]" to stay with all lower and upper letters and digits from 0-9
  use "[^a-z0-9]" to stay with all lower cases and digits from 0-9


class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        
        for ( int i=0; i<s.length(); i++ ){
            char start = s.charAt(i);
            char end = s.charAt(s.length()-1-i);
            if(start != end ){return false;}
        }
        return true;
   
    }
}
```

## 8. String to Integer (atoi)

Implement the `myAtoi(string s)` function, which converts a string to a 32-bit signed integer (similar to C/C++'s `atoi` function).

The algorithm for `myAtoi(string s)` is as follows:

1. Read in and ignore any leading whitespace.
2. Check if the next character (if not already at the end of the string) is `'-'` or `'+'`. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
3. Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
4. Convert these digits into an integer (i.e. `"123" -> 123`, `"0032" -> 32`). If no digits were read, then the integer is `0`. Change the sign as necessary (from step 2).
5. If the integer is out of the 32-bit signed integer range `[-231, 231 - 1]`, then clamp the integer so that it remains in the range. Specifically, integers less than `-231` should be clamped to `-231`, and integers greater than `231 - 1` should be clamped to `231 - 1`.
6. Return the integer as the final result.

**Note:**

- Only the space character `' '` is considered a whitespace character.
- **Do not ignore** any characters other than the leading whitespace or the rest of the string after the digits.

 

**Example 1:**

```
Input: s = "42"
Output: 42
Explanation: The underlined characters are what is read in, the caret is the current reader position.
Step 1: "42" (no characters read because there is no leading whitespace)
         ^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "42" ("42" is read in)
           ^
The parsed integer is 42.
Since 42 is in the range [-231, 231 - 1], the final result is 42.
```

**Example 2:**

```
Input: s = "   -42"
Output: -42
Explanation:
Step 1: "   -42" (leading whitespace is read and ignored)
            ^
Step 2: "   -42" ('-' is read, so the result should be negative)
             ^
Step 3: "   -42" ("42" is read in)
               ^
The parsed integer is -42.
Since -42 is in the range [-231, 231 - 1], the final result is -42.
```

**Example 3:**

```
Input: s = "4193 with words"
Output: 4193
Explanation:
Step 1: "4193 with words" (no characters read because there is no leading whitespace)
         ^
Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
             ^
The parsed integer is 4193.
Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
```

 

**Constraints:**

- `0 <= s.length <= 200`
- `s` consists of English letters (lower-case and upper-case), digits (`0-9`), `' '`, `'+'`, `'-'`, and `'.'`.



```java
class Solution {
    public int myAtoi(String s) {
        // trim the string 
        s = s.trim();
        // if the string has 0 lenght return 0
        if(s.length() < 1){return 0;} 
        
        int sign = 1;
        int i = 0;
        
        // check for sign 
        if(s.charAt(0) == '-'){
            sign = -1;
            i= 1;
        }else if ( s.charAt(0) == '+'){
            i = 1;
        }
        
        
        // find the valid answer
        
        int answer = 0;
        for (; i<s.length(); i++) {
            int num = s.charAt(i) - 48; // minus 48 to get the digit based on ASCII values
            if(num>=0 && num <=9) {
                if(sign > 0) {
                    if( answer <= Integer.MAX_VALUE /10 && ((answer * 10) < Integer.MAX_VALUE - num)) {
                        answer = answer * 10 + num; // clamping 
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
                if ( sign < 0 ) {
                    if( answer * sign >= Integer.MIN_VALUE / 10 && ((answer * 10) *sign > Integer.MIN_VALUE +    num )) {
                        answer = answer * 10 + num;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
            }
            else{
                break;
            }
        }
        return answer * sign;
        
        
    }
}
```

## 14. Longest Common Prefix



Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string `""`.

 

**Example 1:**

```
Input: strs = ["flower","flow","flight"]
Output: "fl"
```

**Example 2:**

```java
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
```

```java
class Solution {
   public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    for (int i = 0; i < strs[0].length() ; i++){
        char c = strs[0].charAt(i);
        for (int j = 1; j < strs.length; j ++) {
            if (i == strs[j].length() || strs[j].charAt(i) != c)
                return strs[0].substring(0, i);             
        }
    }
    return strs[0];
}
}
```

# LinkedList

## 237. Delete Node in a Linked List

There is a singly-linked list `head` and we want to delete a node `node` in it.

You are given the node to be deleted `node`. You will **not be given access** to the first node of `head`.

All the values of the linked list are **unique**, and it is guaranteed that the given node `node` is not the last node in the linked list.

Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:

- The value of the given node should not exist in the linked list.
- The number of nodes in the linked list should decrease by one.
- All the values before `node` should be in the same order.
- All the values after `node` should be in the same order.

**Custom testing:**

- For the input, you should provide the entire linked list `head` and the node to be given `node`. `node` should not be the last node of the list and should be an actual node in the list.
- We will build the linked list and pass the node to your function.
- The output will be the entire list after calling your function.

**Example 1:**

![img](leetcode%20Question/node1.jpg)

```
Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
```

**Example 2:**

![img](leetcode%20Question/node2.jpg)

```
Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
```

 

**Constraints:**

- The number of the nodes in the given list is in the range `[2, 1000]`.
- `-1000 <= Node.val <= 1000`
- The value of each node in the list is **unique**.
- The `node` to be deleted is **in the list** and is **not a tail** node.

```java
// Since we don't have info to the head/ previous node. Without the knowdldeg of the previous node, it is not possible to delete the current node
// The qst doesn't say if the given node is tail node. There fore we can delete the next node instead of the current goven and pretent that the node we are  given is the next node

// Alogarithm 
// store the next node in a temporary variable
// copy the data of the next node to the current node 
// change the next poitner of the current node to the next pointer of the next node


class Solution {
    public void deleteNode(ListNode node) {
      ListNode nextNode = node. next;
      node.val = nextNode.val;
      node.next = nextNode.next;
      nextNode.next = null;
    }
}
```



## 19. Remove the Nth Node from the end of List

Given the `head` of a linked list, remove the `nth` node from the end of the list and return its head.

 

**Example 1:**

![img](leetcode%20Question/remove_ex1.jpg)

```
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
```

**Example 2:**

```
Input: head = [1], n = 1
Output: []
```

**Example 3:**

```
Input: head = [1,2], n = 1
Output: [1]
```

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // create two pointers at the start of the list 
        
        // move the fast pointer n+1 steps ahead of the slow pointer
        
        // when fast points to null we know that slow pointer is one node ahead of the node we want to 
        // remove so slow.next = slow.next.next // skip/remove the node we want to remove . return the head
        
        
        ListNode startNode = new ListNode (0);
        ListNode slow = startNode;
        ListNode fast = startNode;
        
        startNode.next = head; 
        
        
        for ( int i=1 ; i<= n+1; i++){
            fast = fast.next;
        }
        
        while(fast != null ) {
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return startNode.next;
        
    } 
}
```

## \21. Merge Two Sorted Lists

You are given the heads of two sorted linked lists `list1` and `list2`.

Merge the two lists in a one **sorted** list. The list should be made by splicing together the nodes of the first two lists.

Return *the head of the merged linked list*.

 

**Example 1:**

![img](leetcode%20Question/merge_ex1.jpg)

```
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
```

**Example 2:**

```
Input: list1 = [], list2 = []
Output: []
```

**Example 3:**

```
Input: list1 = [], list2 = [0]
Output: [0]
```

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */



 //Mi NOTES: Always have the current at the tail of the new list


class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tempNode = new ListNode(0);
        ListNode current = tempNode; 
        
        while( list1 != null && list2!= null ) {
            
            if(list1.val < list2.val ) { // check if the node in list 1 is less than the node in list two. 
                current.next = list1; // then move the pointer of the current list to poin to the less node 
                list1 = list1.next;
            }else{
                current.next = list2;
                list2 = list2.next;
            }
            
            current = current.next;
        }
        
        if( list1 != null) {   // if list 2 is null. assume that all nodes in list1 are greater than the tail node in the current and update the pointer of the current to point in list1
            current.next = list1;
            list1 = list1.next;
        }
        
        if(list2!=null) { // similiar case. if list1 node is null. assume all all nodes in list2 are greater than the tail node on the current. update the pointer of the current to point at the list2
            current.next = list2;
            list2 = list2.next;
        }
        
        
        return tempNode.next;
        
    }
}
```



## \206. Reverse Linked List

Given the `head` of a singly linked list, reverse the list, and return *the reversed list*.

 

**Example 1:**

![img](leetcode%20Question/rev1ex1.jpg)

```
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
```

**Example 2:**

![img](leetcode%20Question/rev1ex2.jpg)

```
Input: head = [1,2]
Output: [2,1]
```

**Example 3:**

```
Input: head = []
Output: []
```

 

**solution** 

![reverseSinglyLInkedList](leetcode%20Question/reverseSinglyLInkedList.jpg)



## Left rotation 

A *left rotation* operation on an array of size shifts each of the array's elements unit to the left. Given an integer, , rotate the array that many steps left and return the result.



![Screen Shot 2022-11-13 at 6.58.47 PM](leetcode%20Question/Screen%20Shot%202022-11-13%20at%206.58.47%20PM-8391164-8391169-8391170.png)



**Example**

After rotations, .

**Function Description**

Complete the *rotateLeft* function in the editor below.

*rotateLeft* has the following parameters:

- *int d:* the amount to rotate by
- *int arr[n]:* the array to rotate

**Returns**

- *int[n]:* the rotated array

**Input Format**

The first line contains two space-separated integers that denote , the number of integers, and , the number of left rotations to perform.
The second line contains space-separated integers that describe .

**Constraints**

- 
- 
- 

**Sample Input**

```
5 4
1 2 3 4 5
```

**Sample Output**

```
5 1 2 3 4
```

**Explanation**

To perform left rotations, the array undergoes the following sequence of changes:

```java
public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        
        List<Integer> results = new ArrayList<>();
        for( int i = d; i< arr.size() + d; i++ ){
            results.add(arr.get(i%arr.size()));
        }

        return results;
    }
```



## \138. Copy List with Random Pointer

A linked list of length `n` is given such that each node contains an additional random pointer, which could point to any node in the list, or `null`.

Construct a [**deep copy**](https://en.wikipedia.org/wiki/Object_copying#Deep_copy) of the list. The deep copy should consist of exactly `n` **brand new** nodes, where each new node has its value set to the value of its corresponding original node. Both the `next` and `random` pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. **None of the pointers in the new list should point to nodes in the original list**.

For example, if there are two nodes `X` and `Y` in the original list, where `X.random --> Y`, then for the corresponding two nodes `x` and `y` in the copied list, `x.random --> y`.

Return *the head of the copied linked list*.

The linked list is represented in the input/output as a list of `n` nodes. Each node is represented as a pair of `[val, random_index]` where:

- `val`: an integer representing `Node.val`
- `random_index`: the index of the node (range from `0` to `n-1`) that the `random` pointer points to, or `null` if it does not point to any node.

Your code will **only** be given the `head` of the original linked list.

 

**Example 1:**

![img](leetcode%20Question/e1.png)

```
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
```

**Example 2:**

![img](leetcode%20Question/e2.png)

```
Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
```

**Example 3:**

**![img](leetcode%20Question/e3.png)**

```
Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
```

Solution 

```java
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


```

Solution 1: Use a Hash Map

```java
class Solution {
    public Node copyRandomList(Node head) {
        if( head ==null){
            return null;
        }
        
        Map<Node, Node>map = new HashMap<>();
        
        Node curr = head;
        // put nodes as the key and their copies as values
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        // look up and updtate the next and random for the copy 
        for( Node node : map.keySet()) {
            Node currentNode = map.get(node);
            currentNode.next = map.get(node.next);
            currentNode.random = map.get(node.random);
        }
 
        return map.get(head);
    }
}
```

**Time complexity is O(n) and space complexity is O(n) because we created a hashmap** 

Below solution is in Space complexity of O(1) and time complexity of O(n) 

```java
class Solution {
    public Node copyRandomList(Node head) {
        if( head ==null){
            return null;
        }
    // step 1: Create a copy of node and put them in the next pointer 
        Node original = head;
        while(original != null) {
            // create a new node / clone new nodes
            Node copyNode = new Node (original.val);
            copyNode.next = original.next;
            original.next = copyNode;
            original = copyNode.next;   
        }
        
    // step 2: update the random pointers. Loop throught the whole list and 
   //iterate the newly created list and use the original nodes' random pointers
    // to assign references to random pointers for cloned nodes.
        Node newHead = head.next;
        original = head; 
        while (original != null) {
            Node copyNode = original.next;
            if (original.random != null) {
                copyNode.random = original.random.next;
            } else{
                copyNode.random = null; 
            } 
              original = original.next.next; 
        }
        

        // step 3: unwind the linkedList, and get back to the original one 
        original = head; 
        while (original != null) {
            Node copyNode = original.next;
            original.next = original.next.next;
            if(copyNode.next != null) {
                copyNode.next = original.next.next;
            }else{
                copyNode.next = null;
            }
           original = original.next;
        } 
        return newHead;
    }
}
```



