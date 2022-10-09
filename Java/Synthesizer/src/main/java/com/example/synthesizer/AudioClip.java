package com.example.synthesizer;
import java.util.Arrays;


public class AudioClip {

     static final double durationInSeconds = 2.0;
     static final int sampleRate = 44100;
     byte[] data;
//     short[] samples;

     public static int TotalSamples = (int) (durationInSeconds * sampleRate);

    // constructor
    AudioClip () {
        data = new byte[(int) (durationInSeconds * sampleRate * 2)];
//        samples = new short[data.length/2];

    }

    //methods
    // TODO: convert two bytes into a sample (short)
    public short getSample( int index ){
        short  low = (short) (data[2*index] & 0xFF);
        short   high = (short) (data[2*index +1] << 8);
        return (short) (high | low);

    }

    // TODO convert a sample into two bytes and store them in data (byte[])
    public void setSample( int index, short value ){
        data[2*index] = (byte) (value & 0xff);
        data[2*index +1] = (byte) (( value>>8) & 0xff);
    }

    public byte[] getData(){
        // returns a copy of an array. use Arrays.copyOf()
        return Arrays.copyOf(data, data.length);
    }


    public int getDataSize () {
        return data.length;
    }

}
