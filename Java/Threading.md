# THREADS

## Process vs threads

a process is a running program. And process can not talk to each other. A thread help us to run multiple things concurrenlty. Program will run multiple cores at the same time. 



***Concurrency*** is the process of runnning multiple threads at the same time to get things done. 

**synchronous**: doing one thing one at time.

In reality, the server can't accept many request at the same time. it handles one at  time even thought it looks like it is handling the at the same time. 

A thread is a running function.  threads allows Asynchronous

Thread uses Runnable object to do the actua work

* Runnable is an interface that provide the run() method. 
* you implement a runnable and provide the run() function 
* Then you pass the runnable the thread ( via its constructor)  for it to use

````java
// important thread methods
start() // start running the thread
join () // wait for a thread to finish running 
getId() // returns a unique identifier for the thread objec
Thread.currentThread(); // returns the thread object the current method is running in 

````



## Create a thread (lambda version)

```java
lambda is a  unnamed function 
Thread myThread = new Thread( () -> {
// code to be run in thread
};
// you need start () to make the thread actual run 
// join() ends the thread  
// t.join() // main() waits until my thread is finished                             
```



**main()** is blocked. it can't do anything after calling **t.join()**

keyword  **synchronized** is to a function. It means the function will not allow two thread to execute within that function  at the same time. 



Potential problem happens when two threads are working at the same time. And any data that is read by one thread but can be written by another one.  

NOTES: Threads ebyiri ziri gukorera hamwe, hama imwe igafa data yiyindindi. bitera critical issue. Ugomba gukoresha **synchronized** to prevent the issue from happening. 



## critical section

The not protected section 

* read the value of the variable, `int x = 3`
* change the value  `x = x+2`
* and store the value 



```java
public clss Myclass {
  public synchronized void doit() {}
  
}
Myclass object1 = new Myclass;
Myclass object2 = new Myclass;

// if all these objects try to call doit(). Which one will run first? --> undefined. Our brains tend to think that whichever is written in the code first will be executed, but we don't know. what we for sure know is that one object will run first and the other one will follows because of the keyword synchronized. 

// but they can execute at the same time, because they are different objects and have different variables. 

// to avoid data from being corrupted 
// but synchronized thins you can serialize your progam.
// serialize meaning the program will run in specific order 
// thread serialization occurs when work happening on different threads needs to be executed in a specific order 

```



## Threads in Websocket

* create a thread when the client get connected to us `ss.accept()`
* When do we destroy a thread?  --> when the server is done responding to a client. 
* Garbage colector with do for us 

```
//TODO
/* 1. get the socket from the server
  2. read the headers
  3. send the response
  4. thread ends ...< garbage collector can get rid of it for us.
  
* */
```



# WebSocket Implementation 









