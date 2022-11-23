 # 1. Introduction 

Main point: Use to make web pages interactive

Scipting language: You write some code and immediately run. 

Garbage collected

Pass parametes by reference 

You can use class if you are writing big project 

## 2. Dynamic Typing 

variables don't have explicit types 

```javascript
x = 3; // created x
let y = 10;
y = "hello"; // legal but don't do it. don't change the type of your variable 
var k; // old version scoping changes 

x = [4,7.2,"hello"]; // array with different types
x= {}; // x is an empty object 
x = { "name": "John", "gpa": 3.5} // object 


```

## 3. Objects JavaScript 

it is like a map 

you the map synthax or the field syntax 

```javas
myObject.field // gives you the value of the key field
myObject['field'] // 

let x = { };
x.some.SomeField = 4; 
console.log( x.somefiled );

add a method to x
x.amethod = function ();

```

```javascript
" " & ' ' means the same thing 

x = { };
x.a = 7;
x ['b'] = "hello" or you can write x.b = "hello";

```

## 4. JSON

**Java Script Object Notation** 

'{a:4,  b: "hello, "2" : "two}'

The whole point 

1. to serializing data: turning object into string

2. to store data

It is not allowed to use comment in Json. 

```javascript
{
	"book" : [
	{
	"id " : "444",
	"language" : "c",
	"author" : "dennis"
	},
	{
		"id" : "55",
		"language" : "second" ,
	}
	]
}
```

5. ## Methods 

we add a new field to the object ( where the field is a function)

```Js
let myOb = { };
myObj.mehod = fnction ( a,b ) { ... }
```

## 6. Miscellaneaous 

In JavaScript, the `this` keyword refers to an **object**.

for each loop 

- `for/in` - loops through the **properties** of an object

  ```js 
  for ( let prop in obj)
  ```

- `for/of` - loops through the **values of an iterable objec**t // mostly used one. 

  ```Js
  for ( let val  of obj)
  ```

- `while` - loops through a block of code while a specified condition is true
- `do/while` - also loops through a block of code while a specified condition is true
-  `===` is used for comparing two variables, but this operator also checks datatype and compares two values. Striclty equality 
- `==`  in JavaScript is used for comparing two variables, but it ignores the datatype of variable. loose equality 
- in js strings a compared using == 

```js 
let S1 = "hello";
let S2 = "hello";
S1 == S2 // true

const MAX_Number = 1000; // create a constants 

```

```Js
function main () {
    console.log( "hello World: " , document.head)
}

window.onload = main; // The onload event occurs when an object has been loaded.
```

```js
function doit ( x1, x2, x3) {
    console.log( " x1 is: " + arguments.length );
    console.log( "x2 is: " + arguments.length );
    console.log( "x2 " + x2 );

}

doit(99);

//display 
1
1
undefined 
```

## 7. DOM

Document object Model 

It is mostly a tree object. 



![Screen Shot 2022-10-17 at 10.23.08 AM](/Users/gloriadukuzeyesu/Library/Application Support/typora-user-images/Screen Shot 2022-10-17 at 10.23.08 AM.png)



built inmethods used to select elements 

`.getEkenetbyTageName() ;` // returns an arrray of nodes 

