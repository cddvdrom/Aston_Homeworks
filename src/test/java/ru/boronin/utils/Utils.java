package ru.boronin.utils;

public class Utils {
    public int stringToInt (String string ){
        return Integer.parseInt(string.replaceAll("[^0-9]", "").replaceAll(" ", ""));
    }
}
