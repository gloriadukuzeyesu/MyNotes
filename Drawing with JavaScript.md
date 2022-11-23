Two approaches 

`canvas` and svg

Canvas gives you a context that allow you to draw all sort of stuffs 

gives a frame 

```javascript
"use strict";

let canvases = document.getElementsByTagName("canvas");
let canvas = canvases[0];

let ctx = canvas.getContext( '2d');

let cWidth = canvas.width;
let cHeight = canvas.height;

let myImag = new Image (); // very similar to <img src=" name.jpg">
myImag.src = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Cat03.jpg/1200px-Cat03.jpg";



function main () {
    // ctx. drawImage (myImag,20,20);
    // ctx.lineWidth = 5;
    // ctx.strokeRect ( 20,20,myImag.width, myImag.height); // drawing border

    window.requestAnimationFrame( animate );  

}

window.onload = main;

let xPos = 0;
let yPos = 50;

let goingRight = true;


function animate () {
    erase ();
    ctx. drawImage (myImag, xPos, yPos);

    if ( goingRight) {
        xPos += 15;
    } else {
        xPos -=5;
    } 

    if ( xPos >= cWidth) {
        goingRight = false;
    } else if  ( xPos <= 0) {
        goingRight = true;
    }

    // if ( xPos < ( cWidth - 100 ) ) {
        window.requestAnimationFrame( animate ); 

    
}



function erase () {
    ctx. fillStyle = "#FFFFFF";
    ctx.fillRect ( 0, 0, cWidth, cHeight);
}

function handleClick ( e ) {
    erase ();
    ctx. drawImage (myImag, e.x, e.y);
    ctx.lineWidth = 5;
    ctx.strokeRect ( 20,20,myImag.width, myImag.height); // drawing border
}

document.ondblclick = handleClick;

// document.ondblclick = (e) => { drawImage(e) ; };


```

**Bees game**



```js

let bee = {};
bee.xPos = 0;
bee.yPos = 0;
bee.imag = new imag () ;

// create an array of bee 



```





