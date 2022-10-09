package com.example.synthesizer;

import java.util.ArrayList;

public class Mixer implements AudioComponent {
    ArrayList<AudioComponent> inputs;

    Mixer () {
        inputs = new ArrayList<>();
    }

    @Override
    public AudioClip getClip() {
        AudioClip OutPutClip = new AudioClip();
//        AudioClip clip = new AudioClip();

        for (AudioComponent input : inputs) {
            AudioClip clip = input.getClip();
            for (int j = 0; j < AudioClip.TotalSamples; j++) {
                OutPutClip.setSample(j, (short) (OutPutClip.getSample(j) + clip.getSample(j)));
            }
        }
        return OutPutClip; // TODO call the clamping as here
    }


    @Override
    public boolean hasInput() {
        return false;
    }

    @Override
    public void connectInput(AudioComponent input) {
        inputs.add(input);
    }
}

// adjust the volume and other details I want my mixer to do for each input.
// It could be change the volume, support synchronization,
//When one line in a synchronized group is started or stopped,
// the other lines in the group automatically start or stop simultaneously with the explicitly affected one.

//        inputs.add((AudioComponent) clip);

//        AudioClip original = inputs.getClip();
// inputs_[i] ( uses getClip())
