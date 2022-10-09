package com.example.synthesizer;

import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;



class AudioClipTest {

    public static void main(String[] args) {

         getSample();
         setSample();
//         getData();
        testAudioClip();
    }

    static void getSample() {
        AudioClip test = new AudioClip();

        int index = 5;
        short maxValue = Short.MAX_VALUE;
        short minValue = Short.MIN_VALUE;
        test.setSample(index, maxValue);
        short testMaxValue = (short) test.getSample(index);

        Assertions.assertEquals(maxValue, testMaxValue);
    }

    static void setSample(){
        AudioClip test2 = new AudioClip();

        short maxValue = Short.MAX_VALUE;
        short minValue = Short.MIN_VALUE;

        ArrayList<Short> arrayListOfShort = new ArrayList<>();
        for ( int i = minValue; i<= maxValue; i++){
            arrayListOfShort.add((short) i);
        }
        /* System.out.println("Content of the arrayList are: " + arrayListOfShort); */

        //TODO this test contains the setSample(), getSample()
        for ( int i =0; i< arrayListOfShort.size(); i++){
            test2.setSample(i, arrayListOfShort.get(i));
            Assertions.assertEquals(arrayListOfShort.get(i), test2.getSample(i));
        }

    }

    public static void testAudioClip() {
        AudioClip clip = new AudioClip();
        for (int i = Short.MIN_VALUE, j = 0; i <= Short.MAX_VALUE; i++, j++) {
            clip.setSample(j, (short) i);
            Assertions.assertEquals(clip.getSample(j), i);
        }


    //TODO Still need to work on the getdata()
/*
     @Test
    void getData(){
        // test for getData();
         short maxValue = Short.MAX_VALUE;
         short minValue = Short.MIN_VALUE;

        AudioClip test3 = new AudioClip();
        ArrayList<Short> arrayListOfShort = new ArrayList<>();
        byte [] byteArr = new byte[test3.getDataSize()];


         for ( int i = minValue; i <maxValue; i++){
             arrayListOfShort.add((short) i);
         }
         for ( int i =0; i< arrayListOfShort.size(); i++){
             test3.setSample(i, arrayListOfShort.get(i));
             Assertions.assertEquals(arrayListOfShort.get(i), test3.getSample(i));
         }
        Assertions.assertArrayEquals(test3.getData(), byteArr);
    }

 */



    }
}