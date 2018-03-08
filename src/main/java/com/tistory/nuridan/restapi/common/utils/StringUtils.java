package com.tistory.nuridan.restapi.common.utils;

public class StringUtils {
	
	
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
    
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
    
    public static long getByte(String str) {
        
        if (str == null) {
            return 0;
        }
        long strLength = 0;

        char[] tempChar = new char[str.length()];
        try {
            for (int i = 0; i < tempChar.length; i++) {
                tempChar[i] = str.charAt(i);
                if (tempChar[i] < 128) {
                    strLength++;
                } else {
                    strLength += 3;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return strLength;
    }
    
    public static String getByteCut(String str, int putByteLength, String delimiter) {
        int strLength = 0;

        char[] tempChar = new char[str.length()];
        StringBuilder stb = new StringBuilder();
        try {
            for (int i = 0; i < tempChar.length; i++) {
                tempChar[i] = str.charAt(i);
                if (tempChar[i] < 128) {
                    strLength++;
                } else {
                    strLength += 2;
                }
                stb.append(tempChar[i]);
                if (strLength > putByteLength) {
                    stb.append(delimiter);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stb.toString();
    }
}
