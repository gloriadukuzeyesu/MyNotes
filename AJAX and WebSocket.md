* Each time a user enters a new message, how could you updtate the webpage?

* asks the server for the new message: This method os asking data is called **polling**

  

AJAX is a developer's dream, because you can:

- Read data from a web server - after the page has loaded
- Update a web page without reloading the page
- Send data to a web server - in the background



Ajax is a client side approach 

The connection stays open until closed by one side



WebSocket approach: Used over the web

socket because it is a endpoint of two hots tthat allow two communication between them



how do we send data over message: use a `SendMessage(data)` method that sends message to the server

use `msgData = receiveMessage()` // anticipate the server's response

## Web socket-Js

```js
how to setUP the websocket 
let ws = new Websocket ( "Ws:localhost:8080");
ws.onopen = handleConnectCallBack; // 
ws.onclose = handleColoseCallBack; 
ws.onerror = handleErrorCallBack;
ws.onmessage = handleMessageCallBack;
ws.send( message ) // send message to the server 
ws.close(); //close it if done wit the websdocket 
```

when do we send message: -> based on the event, 

when does the msg is displaye message? `onmessage`;

443 is the http protocol. 80 is not used bcz low numbers are reserverd. 



### Use webSeocket HandShake 

between client( browser) and web server 

websocket usually use port 80 a=or 443 

it is a two way communication that stays open and the solver is allowed to everybody. However with AJAX returns a single response to a single request



