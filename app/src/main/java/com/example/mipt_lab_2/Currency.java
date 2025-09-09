package com.example.mipt_lab_2;

public class Currency {
    public final String code;
    public final String value;

    public Currency(String code, String value) {
        // I hope no logging is needed for the instantiation of a class this small :]
        this.code = code;
        this.value = value;
    }
}