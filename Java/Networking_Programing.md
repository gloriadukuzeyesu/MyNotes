# Streams

*  Java uses Streams and Adapters for Input streams and out put streams 

  * Example of input streams: System.in (stream connnected to the console), file input 

  * Example of output streams include: System.out, FileOutPutStream 
  
  
  
  


# Adapter

Streams are read or write in bytes 

Java uses Adapters to wraps streams and provide high lever operation 

* **Input**: use scanner. Scanner can reads multiple bytes and parses or returns numereic values and strings 

* **OutPut**: Wraps outstream with PrintWriter

  

# Java Network programming:

 It is all about sending one bytes at the time.  So we need to be able to read and write bytes 

* in Network programming, we get input and output stream using **socket** 

* socket are open TCP connectin to a program where else 

* Mostly used Classes 

  * **Socket** : a client socket that cpnnect to a given IP address and port 

  * **ServerSocket** - a server socket that listens for connections. Server uses both socket client and serversocket 

    * !! ServerSocket doesn't conains socket. It creates one when a client is connect to it 

      

  ## Lifecycle of a server socket 

  * a server socket waits around until a client tries to connect 

    **STEPS: ServerSocketAPI** 🤩

    

    ![Screen Shot 2022-09-29 at 11.52.54 PM](/Users/gloriadukuzeyesu/Desktop/ccc.png)

    Reference 

    https://www.codejava.net/java-se/networking/java-socket-server-examples-tcp-ip

    


A socket contains a **IP** address and a **port** 

## Socket I/o

once we have opened the socket we call **getInputStream**() or **getOutstream**() method 

Use flus() method to senf any output data immediatetly

Buffere is a an array. use flush() to send data immediately 



## Tcp connection 

Indentifed by 4 numbers 

* Sources / destination IP address
* Client  port # is randomly chose by the os  (usually the large number )

## Exceptions



## Basic HHTP Server 

// for only day4 assignment purposes 

* Only writing the serversocket for server 
* what will use for a client. -> browser safari or any 
* Curl( sedns stuff to server a good way to star )
* Connect to 127.0.01( this is alwasys your machine)
  * or **local host** -> recommeded 
  * Whatever your IP address is, will change from day to day 
* Use localhost:8080

## HTTP Headers 

* GET
* POST
* HEAD 

**client request:** 

Get / HTTP/1.1

Host: local host

Accept language: fr 

how does the server know when the clients's request header is done -> **blank line**  

sudo code of how to listen to the request from a client. Get the request, process it, and send back the requested data. 

```java
ServerSocket ss;  //class 

while ( true ){
  socketToClient = ss.accept ( ); // have a connection to cleint 
  
  inputstream = socketToClient.getInputStream (); // stream data
  
  Scanner sc = new Scanner (inputStream ); // shover them in scanner to be able to read in 
  
  // only read the 1st line once 
  String line = sc. nextline ();
  // split into 3 pieces
  String filename = line [1]; // pseudo code <- this is not valie java 
  
  while ( the line is not blank ){  
   // read header line 
    String line = sc. nextline ();
    //beak 'line into key: value pairs'
    //store in hashMap 
  }
  // reading the header is done . next step is to send the response 
}
// open the requested file ('filename')

if open successfully , then 
  result = " 200 sucess"
  else
    result = "404 not found "
    
outputstream = socketToCkent.getOutPutStream () ; 
printeWriter pw = new PrintWriter ( outputStream ); 


// send the response header
ps.println (" http/1.x " + result);  // println to print on a new line 

// determine the file extension ( eg. html or .css) and use it here. 
pw. println (" Content-Type: text/ext"); //  ext should be either .html or .css
// not include charst -8, the browser will do it for you 
pw. println (" size: " + size of the file ");
//ends the response header 
pw.print ("\n")
             
// now senf the data from the file 
while ( read line from file ){
  pw. print(line) // this is just one line at time. But the assigment says to send the whole file at the same time. 
}

socketToClient.close();

```

the broswer usually ask for two files:  the HTML and the CSS files same time 









#####     
