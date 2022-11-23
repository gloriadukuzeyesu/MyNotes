

// const array1 = ['a', 'b', 'c'];

// for (const element of array1) {
//   console.log(element);
// }
// let x = "3";

function main () {
console.log( "hello World: " , document.head)
// document.writeln ("<p> hi <p>")
let myp = document.createElement('p'); // <p> 
let myText = document.createTextNode(" This is my paragraph hahah")
myp.appendChild( myText );
myp.style.background = "lightblue";
myp.style.fontWeight= "bold";

document.body.appendChild ( myp );

let myH1s = document.getElementsByTagName ( 'h1')
let myH1 = myH1s[0];

console.log ("myH1" + myH1 );
// myH1.innerHTML = "<p>P1</p> <p>p2</>";

}




window.onload = main;

// // console.log( "hello Wolrd" + document.head);

// // console.log( "hello Wolrd" , document.head);

function doit ( x1, x2, x3) {
console.log( "x1 is: " + arguments.length );
console.log( "x2 is: " + arguments.length );
console.log( "x2 " + x2 );

}
doit(99);

document.writeln ("<p> Hello from document.Writenln <p>")


