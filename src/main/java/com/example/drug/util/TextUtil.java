package com.example.drug.util;

public class TextUtil {

    public static boolean isEmpty(String str){
        if (str == null || str.equals("")){
            return true;
        }
        return false;
    }
}
