package com.example.synthesizer;


public class linearRamp implements AudioComponent {
    int Start;
    int Stop;
    AudioClip OutPutClip = new AudioClip();

    linearRamp( int start, int stop) {
        this.Start = start;
        this.Stop = stop;
    }

    @Override
    public AudioClip getClip() {
        for (int i = 0; i < AudioClip.TotalSamples; i++) {
            OutPutClip.setSample(i, (short) ((Start * (AudioClip.TotalSamples - i) + Stop * i) / AudioClip.TotalSamples));
        }
        return OutPutClip;
    }
    @Override
    public boolean hasInput() {
        return false;
    }

    @Override
    public void connectInput(AudioComponent input) {
    }
}

