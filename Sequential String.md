Sequential String

A special string s of length n consists of characters 0-9 only. Its characters can only be accessed sequentially ie the first '1' chosen is the leftmost '1' in s. There is an array arr of m strings, also consisting of characters 0-9. Calculate the minimum number of characters needed from s  to construct a permutation of each of the
strings in arr.



Return an array of integers where the ith element denotes the minimum length of a substring that contains a permutation of the ith string in arr. If a string cannot be constructed, return -1 at that index.



Example

Consider n= 12,  s= "064819848398", m = 3, arr = ["088", "364", "07"]

* To construct "088", Alice needs to access the first 7 characters ("**0**64**8**19**8**48398") of the special string and use only '0', '8', and '8'.  Since the characters can be rearranged, the results for '088', '808', and 880' are all 7.
* ﻿To construct "364", access the first 10 characters ('**064**8**198483**98") of the special string and use only '6', '4', and '3'. Rearrange to match "364"
* ﻿String "07" cannot be constructed from the special string. No '7' is available.
* The return array is [7, 10, -1]. Note that only bolded characters are used to construct the strings.





Function Description

Complete the function countMinimumCharacters 
countMinimumCharacters has the following parameters:
string s : the special string of length n 

string arr [m]:  strings to construct

Returns
int[] :  the ith element corresponds to the minimum number of characters required to construct the i th string, or -1 if the string cannot be constructed. 



Example

s = "111222333444"
size of arr,  m = 4
arr =  ["121", "3", "12345"]



output  List 

[4,7,-1,10]

  •    ﻿i = 0, the string "121" can be constructed by accessing the first 4 characters ("1112") of the special string.
    •    ﻿i= 1, the string "3" requires ("1112223").
    •    ﻿i= 2, the string "12345" cannot be constructed since there is no '5' in s.
    •    ﻿i=3, the string "11234" requires ("1112223334").

