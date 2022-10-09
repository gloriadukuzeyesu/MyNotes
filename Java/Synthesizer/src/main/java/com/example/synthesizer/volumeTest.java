package com.example.synthesizer;

import org.junit.jupiter.api.Test;

class volumeTest {
    @Test
    public void runAllTest() {

        SineWave sineWave = new SineWave( 44100);
        Volume MyVolume = new Volume(0.5);
        MyVolume.connectInput(sineWave);




    }

}