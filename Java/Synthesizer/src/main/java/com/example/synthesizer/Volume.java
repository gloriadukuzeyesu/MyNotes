package com.example.synthesizer;

public class Volume implements AudioComponent{

    double volumeScale;
    AudioComponent input_; // from the interface AudioComponent how to bring in your sineWave

    // constructor
    Volume(double vol ) {
        volumeScale = vol;
    }

    @Override
    public AudioClip getClip() {
        AudioClip AdjustedClip = new AudioClip();
        AudioClip original = input_.getClip();


        for ( int i= 0; i< AudioClip.TotalSamples; i++){

            double adjustedVolume = volumeScale * original.getSample(i);

            if ( adjustedVolume > Short.MAX_VALUE) {
                adjustedVolume = Short.MAX_VALUE;
            } else if (adjustedVolume < Short.MIN_VALUE) {
                adjustedVolume = Short.MIN_VALUE;
            }
            AdjustedClip.setSample(i, (short) adjustedVolume);
            // Todo create a clamp () in the AudioComponent and call it here and in the mixer getClip()
        }
        return AdjustedClip;
    }

    @Override
    public boolean hasInput() {
        return false;
    }


    @Override
    public void connectInput(AudioComponent input) {
        input_ = input;
    }
}
