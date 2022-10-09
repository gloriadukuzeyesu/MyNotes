package com.example.synthesizer;

import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.util.ArrayList;

public class Main {

    public static  void  main( String [] arg ) throws LineUnavailableException {

        // Get properties from the system about samples rates, etc.
        // AudioSystem is a class from the Java standard library.
        Clip c = AudioSystem.getClip(); // Note, this is different from our AudioClip class.

        /* This is the format that we're following: 44.1 KHz, 16 bits per sample, mono audio,  signed bytes,  littleEndian*/
        AudioFormat format16 =  new AudioFormat(44100, 16, 1, true, false);

        AudioComponent gen = new SineWave(220);
        AudioClip testClip = gen.getClip();
        /*TODO uncomment to play the testClip */
//        c.open(format16, testClip.getData(), 0,testClip.getData().length);

        /*  Test to adjust the Volume  */
       Volume MyVolume = new Volume(0.5);
       AudioComponent NewSineWave = new SineWave(220);
       MyVolume.connectInput(NewSineWave);
       AudioClip myVolumeClip = MyVolume.getClip();
       /*TODO uncomment to play myVolumeClip clip, adjust the volume to test the Volume functionality*/
       c.open(format16, myVolumeClip.getData(), 0,myVolumeClip.getData().length);

        /*  test for mixer, use the already created sine wave, gen and newSineWave */
        Mixer myMixer = new Mixer();
        myMixer.connectInput(NewSineWave);
        myMixer.connectInput(gen);
        MyVolume.connectInput(myMixer);
        AudioClip mixerOut = MyVolume.getClip();
        /*TODO uncomment to play the mixerOut clips*/
//        c.open(format16, mixerOut.getData(), 0,mixerOut.getData().length);

        /* test for linearRampAudioComponent  */
        AudioComponent liner_Ramp = new linearRamp(50, 20000);
        VFSineWave vf_SineWave = new VFSineWave();
        vf_SineWave.connectInput(liner_Ramp);
        Volume VolumeAdjuster = new Volume(1);
        VolumeAdjuster.connectInput(vf_SineWave);
        AudioClip linearClip = VolumeAdjuster.getClip();
        /*TODO uncomment to play the linearClip, adjust different start and stop, creates funny sounds */
//        c.open(format16, linearClip.getData(), 0,linearClip.getData().length);

        System.out.println("About to play ");
        c.start(); // Plays it.
        c.loop(2); // Plays it 2 more times if desired, so 6 seconds total

        while ( c.getFramePosition() < AudioClip.TotalSamples || c.isActive() || c.isRunning() ) {
            // Do nothing while we wait for the note to play.
        }

        System.out.println("Done");
        c.close();

        // create a listener whihc waits until the clip is closed and move the close () in the Audio listener() inside
        // the update() methods, that will update the clip each time is it is played

    }
}
