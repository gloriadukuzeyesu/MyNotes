package com.example.synthesizer;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

public class AudioListener implements LineListener  {

    //fields
    private  Clip clip_;

    //constructor
    public AudioListener(Clip c) { clip_ = c; }

    //methods
    @Override
    public void update(LineEvent event) {
        if ( event.getType() == LineEvent.Type.STOP ) {
            System.out.println("Close Clip");
            clip_.close();
        }
    }

}
