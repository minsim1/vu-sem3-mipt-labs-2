package com.example.mipt_lab_2;

import java.util.Arrays;

public class StringCounter {
    // Will not split at question mars and exclamation marks
    // Will split at white spaces, commas and periods
    public static int countWords(String str){
        if(str == null || str.isBlank()){
            return 0;
        }

        // Thank you chat gpt for you regex magic
        String[] words = Arrays.stream(str.trim().split("[\\s,.]+"))
                .filter(s -> !s.isBlank())
                .toArray(String[]::new);

        return words.length;
    }

    // Will count white spaces aswell
    public static int countChars(String str){
        return str.length();
    }
}
