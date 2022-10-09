package com.example.synthesizer;
import static java.lang.Math.PI;
import static java.lang.Math.sin;

import jdk.jfr.Frequency;


public class SineWave implements AudioComponent {

    int frequency;

    // constructor
    SineWave ( int pitch) {
        frequency = pitch;
    }

    @Override
    public AudioClip getClip() {
        AudioClip myAudioClip = new AudioClip();
        for (int i = 0; i < AudioClip.TotalSamples; i++){
            myAudioClip.setSample(i, (short) (Short.MAX_VALUE * sin ( 2 * PI * frequency * i/ AudioClip.sampleRate))) ;
        }
        return myAudioClip;
    }

    /* can connect something to this as an input */
    @Override
    public boolean hasInput() {
        return false;
    }

    @Override
    public void connectInput(AudioComponent input) {
    }
}
