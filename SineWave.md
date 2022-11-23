SineWave.java

```
package com.example.synthesizer;

interface AudioComponent {
    /* return the current sound produced by this component */
    AudioClip getClip();

    boolean hasInput();

    /* connect another devise to this input. this method stores a reference to AudioComponent parameter
    if the audion doesn't accept input, assert (false) */
    void connectInput( AudioComponent input);

}


public class SineWave implements AudioComponent {

    private int frequency;


    //constructor
    SineWave (int FREQ ) {
        frequency = FREQ;
    }

//
//    public AudioClip getClip() {
//    }


//
//    public boolean hasInput() {
//
//    }


//
//      public void connectInput(AudioComponent input){
//
//      }

}
```



The purpose of an audio clip is represented as a **sound wave**. 



to avoid lock up the button 



remove the while () and cread a listen and add a listene r