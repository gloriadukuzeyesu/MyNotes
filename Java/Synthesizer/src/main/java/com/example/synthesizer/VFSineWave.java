package com.example.synthesizer;

import static java.lang.Math.PI;
import static java.lang.Math.sin;

public class VFSineWave implements AudioComponent{

    AudioComponent input_;

    VFSineWave () {
    }

    @Override
    public AudioClip getClip() {
        AudioClip vf_SineWave = new AudioClip();
        AudioClip inputClip = input_.getClip();

        double phase = 0;
        for ( int i=0; i< AudioClip.TotalSamples; i++){
            phase += (2 * PI * inputClip.getSample(i) / AudioClip.sampleRate);
            vf_SineWave.setSample (i , (short) (Short.MAX_VALUE * sin(phase)));
        }
        return vf_SineWave;
    }

    @Override
    public boolean hasInput() {
        return false;
    }

    @Override
    public void connectInput(AudioComponent input) {
        this.input_ = input;

    }
}
