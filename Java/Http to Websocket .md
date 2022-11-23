Changing protocols from HTTP to webscoket

Client sends a request which has a key 

`Sec-WebSoecket-Accept: <value>  ` means that the client wants to do webSocket 



Websocket handshake 

Sec-WebSoecket-Accept: <value>  

* Concatenate the client's Sec-WebSoecketKey and the magic string
* The use the SHA- Hash and Base64 to has it and get the Sec-WebSoecket-Accept: <value> value. 
* MessageDigest call will do the SHA-I hashing. Create an object of MessaheDigest Class a
* Base64 class will encode the output of the Message Digest into a string 

You will generate the header request from `Websocket wb = new Websocket (URL)` and get the client key from there



The first 2 bytes 

The fin telll us whether this is the only packet in this msg 

opcode is the last 4 bits . if it is equal to 1-> everything is good. 

if it is numbe 1, it means it is a text message 

The 2nd bytes tells us 

* spec
* if the message is masked 
* the length. If he length == 126, it means there is an exetended payload length 

Frame format:

      0                   1                   2                   3
      0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1
     +-+-+-+-+-------+-+-------------+-------------------------------+
     |F|R|R|R| opcode|M| Payload len |    Extended payload length    |
     |I|S|S|S|  (4)  |A|     (7)     |             (16/64)           |
     |N|V|V|V|       |S|             |   (if payload len==126/127)   |
     | |1|2|3|       |K|             |                               |
     +-+-+-+-+-------+-+-------------+ - - - - - - - - - - - - - - - +
     |     Extended payload length continued, if payload len == 127  |
     + - - - - - - - - - - - - - - - +-------------------------------+
     |                               |Masking-key, if MASK set to 1  |
     +-------------------------------+-------------------------------+
     | Masking-key (continued)       |          Payload Data         |
     +-------------------------------- - - - - - - - - - - - - - - - +
     :                     Payload Data continued ...                :
     + - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - +
     |                     Payload Data continued ...                |
     +---------------------------------------------------------------+

Responding 

When the server sends back the msg it is unmacked 

Who keeps track of everything is the server 



### CHAT SERVER

Turn your webserver echo into a chat server 

You need a room object



1. Print the hashmap
2. loop for the keyvalue  sec-web socket-key 
3. get the value 
4. append the key to magic key  to make the SecWebSocketAcceptkey 
5. get the  SecWebSocketAcceptkey 
6. Respond back to the client to establish a handshake. Basically acceptance of the connection 
7. 
8. g
9. data input stream
10. 
11. 

