package com.example.mipt_lab_2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCounterTest {
    @Test
    public void wordCountTest(){
        assertEquals(2,StringCounter.countWords("   labas,. ., .,   ., vakaras!    "));
    }

    @Test
    public void characterCountTest(){
        assertEquals(6,StringCounter.countChars("  ,.  "));
    }
}
