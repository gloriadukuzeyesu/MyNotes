

# Application System Design



* Classes of UI elements 
* Callbacks ( onlcick handles)
* Mark up language to describe UI 

Android UI

* Activities : screens 
* Views : UI Elements
* Fragments: grouping of the UI elements views. 

## For Designing layout :  

* XML file fot layout 
* Kotlin file call back 

Fragments can contains other fragments. Activity contains fragments. Use fragments and navigate between them. Nice way to navigate thru fragments. 

### Common Layouts: 

* Linerar layout: row and column orientation. fun hahah 

* GridLayout : Arrange things in grid view

* Table Layout 

* Frame Layout: Does nothing. Draws things on the top of each other. 
* Constraint Layout : Have childdren and specify the constrains according to the parent. Organize them and they can adjust the based on how you want. ( Not present to use, pain in the butt accoring to Dr.Jones)

### View Attributes

* Width/height : Fixed size
* Match parent: Expand as big as possible to the parent size ( can be width or height)
* Wrap content: Be as big you need to be to fit the parent. 
* Padding /marging ( padding is more like increaing background and margin is more of increasing the space with the other)
* Gravity: top, Botton, center around left and right 
* Layout gravity
* Colors 
* Size : unit size is : "display pixels,  **'dp'** and text size is **'sp'** scale pixels



## Lecture 2: Activities and Intents 

Click listener 

```kotlin
   findViewById<Button>(R.id.buttonID).setOnClickListener { myview : View ->
            Log.e("GD", myview.toString()) // e stands for error , d for debug. Best practice use, the tag as the fragment name
            textView = findViewById<TextView>(R.id.textViewID) // val means  constant
//            textView.text = "Next Text"
            textView.text  = "Gloria"
        }
```

```kotlin
findViewById<Button>(R.id.buttonID).setOnClickListener(B)
var clicklistern = View.OnClickListener() { // OnClickListener is an interface. Which has one method. we don't need to call it you can just implement it. Refer to Ben's code
}

```

### Data binding

* get the binding object for each fragment or activity. It returns a view that can help identingy the types of the views. To avoid mis match of the file. 

  In the app gridle. Add these code and instead of findingViewbyID, this time, you'd have to do `binding.id`

  ````kotlin
   buildFeatures {
          viewBinding = true
          dataBinding = true
      }
  ````

* In the oncreate method. Add the. Binding and inflate the layout/activity 

  ```kotlin
  val binding = A.inflate(layoutInflator)
  binding.buttonID.setOnclickListener{}
  setContentView(binding.root) // don't use the id
  ```

### Toasts

* A pop message that goes comes and goes away 

  ```kotlin
  Toast.maketest(this, "Invalid bla", Toast.LENGTH_SHORT).show() // this is the context. Use the current activity that you want the message to display. 
  ```

### Linking Activities: intents

* Swtiching between the activities

  2 types of intents 

  * Explicity intents
  * Implicity intents 

#### Explicity Intents 

* `val intent = Intent(this, Activity::class.java)`

  to store intents with things when sending them out.Use a `Bundle()`

  ````kotlin
  val msbundle = Bundle()
  msbundle.putString(Key,value)
  intent.putExtras(msbundle)
  ````

  `when` is like a `switch case` in java.

#### Implicits: Maps and Camera

* Implicits intents Maps: , you don't identify the activity to go to. The App comes decided on what to switch to. For example. using URI and switch of the maps. You don't have to necessary say switch top other maps. 
* IMplicity Camera. in the hash map, there is a `Bitmap::class.java` 



URI is  

Lifecyle

## Android Activity Lifecycle methods

![image](../Files/image.png)



onDestroy() is like a destructor in c++. 

The garbage collector, there is no ordering. But in destructor there is 

Finalilzers in c#, the idisposable interface. used `using()` and that is calling idisposable in the end of the `{}` 

### Stroring data

* In activity: member variable. If we destroy and recreate the activity, the member variable will be lost. 
* in VIEWs ( like the text that is written in the view)
* If We need data to persit, we use callback cakksed `on SaveInstanceState()` it gives a way of storing data in bundles. `onRestoreInstanceState()` allows to grab data and update the views. 
* This is a bad design. BCz each time you create the activity, you'd have to remember the data. Save and restore all the time. 

Example: Create a Todo List

* add and remove items
* Views you might need are Edit text to add anew, button, list. 

## MVVM Architecture

Model View View Model 

VIew: What we see

Model: **Will store the data.** 

ViewModel ---> Views : Any data thaat we need 
Views ----> VM user interaction should update teh model. 

VM--> Model : Change 

Model --> VM -> get data 

#### What we need to implement MVVM architecture

* VM class in Android are life cycle. : perist through life cycle. They will not be part of the lifecle of the activity. 

* change the model methods, normal methods. The names of the method should reflect how the data is being change. 

* Create a LIVE DATA class, wrapper class. Wrapp around the values, `LiveData<String>` . Views observer live data. There is observe method that takes a call back and anytime we update the data, the data is updated in the view. This is automatically. View models handles what the data changes are and the views don't know what is going.  `observe()` gets the lifecylce owner as parameter. such as `observe(this)`

* In order to create a viewModel object you use, the delegated syntax. use `by` keyword. 

  

#### Displaying Data in a list 

* Use a **RecylerView**. YOu need three classes to use it. Solves containsts layout. 
  * Layout manager: How to organize individual laid out. A snippet of view 
  * View Holder : Keeps tracks of layout template. and gets resused when scrolling. 
  * Adapter: Responsible creating views when needed. Creating and rebinding the new view holder. 
  * Animator: Animation cnagneg of the list. (optional)

Kotlin Delegated property. 

* propery that calls another project. 
* It does have a lazy 
* If you run your project for the first time, it creates the viewmodel object and will be used every single time you run your program. It doesn't recreate that object. It is only created once. That is why it is called a lazy. 

if is an expression in Kotlin and it has a value as opposed to statement. There is a difference between kotlin and statement. 

* DOn't touch data outised the view model except through the observer. 



## Fragments 

Activities are like screens. 

View models are always associated with activities. For example if you have one activity, you view model will be used to share data accrooss that one activity. It is tricky to share one view model with amny activites. The solution is to have multiple fragments for one activity and just have one activity. 

* a fragment is a reusable activity 
* groupping things together 

You can switch fragments at run time. 

Have a view container in activity that will hold the fragments at run time. 
`SupportFragmentManager.beginTransaction()`  this will change the fragment at runtime.  Add a string tag so that you can access it later. There is no ID for fragments. 

If you know ahead of time what fragment you want in your activity, you can have a fragment layout in your activity xml layout. This case you have the ID for the Fragment that you can use in case you want to search for this specific fragment later. Use `findViewByID()` 

* Always use the view model as the source of data. let all fragments get their data from the view model. There is a delegate for just fragment. use ` by activityViewModels()` 

### commonly used Callbacks for fragments 

* On create()
* `OncreateView() ` : mostly used one. The only one that is we might use. 
* on Pause() : you can use this mabye when you 

## Custom Views

* create your own class that inherit from View. 

* Constructor signature is particular . It must looks like this. Two member variables which are context and attributes. 

  ```
  class mycustomView(contex: Context, attrs: attributeSet) : View(context, attrs)
  ```

* Bunch of callbacks that are inherited from View. But the most important one is `onDraw(canvas: Canvas)`  

  * canvas is an object that can be used to draw
  * Canvas comes with a bitmap class that you can draw on. Image you draw, you draw it on the bitmap
  * the canvas class has a `drawbitmap()` that copies content from the 

* `addtobackStack()` is a way of going back to the prev fragment. use the back arror on the emulator. 



# Jetpack

* Jet pack is an Androud libraries for Android. 

* ViewMode + LiveData Classes + libraries  are all part of Jet Pack

  ### Navigation we've seen so far

* View model : Data persitence, lifecycle, data sharing 
* Intent : navigate between activities
* Fragment Transaction manager : construct Fragmebt object to navigate 

## 	Navigation Graph

* Allows to have the path between parts of the app as graph. Usually it is in the form of xml. 

   To create a navitation graph 

  ```
  1. right click new on the res
  2. choose "android resource file"
  3. select navagation
  ```

* Jet pack Navigation helps us with navigation through out the app. We get rid of  fragment transactions.

* Nodes of the graph becomes our fragments. 

* Navigation Graph also allows us Deep linking: Deep linking is a link (url) that takes you directly to a specific destination within an app. This link can also take you back.

* To do this, we'll have our Activity just show a `FragmentContainerView` which will show a `NavHostFragment`

* You'll need to set these XML attributes: 

  ```kotlin
  app:defaultNavHost="true" 
  app:navGraph="@navigation/your_xml_file
  ```

* This fragment will use the Navigation graph to determine which fragment to show first, and will respond to navigation requests and update the fragment for us

### 	Navigating 

* The easiest way is to navigate is the `findNavController().navigate(R.id.theFragmentId)` . This hack also manages the back stack for us. 

* There is a long tuitotial on the website about this.Check it out! 

  

# Testing 

## 1. Unit Testing 

* Use  JUnit Library

* Any code that isn't UI related such as Views and event listener stuffs should all be tested in the folder 

   `java.your.package.test.folder`

* ViewModels should also be tested here. 
* Test plain function that you declare 

### Junit 

* #### Test ( found in test directory ) 

   * Contains Kotlin code. These are plain tests. 
     * Goes in `test` folder 
   * Data processing, vanilla Jnuit, 
   * Test plain function that you declare 

* #### Instrumental test 

  * Works fine with Kotlin code that atre not Android Specific 

  * Goes in `android test folder`	

  * These tests do run on the emulator and go in android test folder 

  * Use mocks for testing. Helps makes sure that you are using the most interface. It helps you focus your design. 

  * Some code that requires android to run some goes here. 

  * Use instrumental test to test code that uses Android classes such as `Color` 

  * Live Data requires Android component to run so goes in instrumental tests. 

  * These instrumental tests give you access to other android projects including Context object. ect. Whihc is nice bcz you can test part of the app without running full the whole app. 

    

### UI Testing : Espresso.

* A libray that you can use to test the full app

* Allow us to test your full app's UI. enable you find views by ID. Once you have the view you can verify that you have the what you want to have. Example, does the view contains a text that you want.

* It will be slower compared to other testing bca you have to rerun the whole app. 

* Easy to write tests that perform sequences of user actions and then assert that the app bheaves as expected. 

  
