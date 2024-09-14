package com.example.naja.core.utils;

public class StringUtils {
    public static String toCapitalized(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
