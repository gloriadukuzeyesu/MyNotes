package com.example.synthesizer;

public interface AudioComponent {

    /* return the current sound produced by this component */
    AudioClip getClip();

    boolean hasInput();

    void connectInput( AudioComponent input);

}
