package com.taskmaster;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Palindrome {
    public static boolean isPalindrome(String word){
        word =  word.replaceAll(" ", "").toLowerCase();

        for(int i = 0; i < Math.floorDiv(word.length(),2); i++) {
            if(word.charAt(i) != word.charAt(word.length()-(i+1))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagramOfPalindrome(String word) {
        word = word.replaceAll(" ", "").toLowerCase();

        int wordLength = word.length();

        Map<String, Integer> charOccurrence = new HashMap<>();

        Arrays.stream(word.split("")).forEach((c) -> {
            int occurence = charOccurrence.getOrDefault(c,0);
            charOccurrence.put(c, occurence+1);
        });

        if ( wordLength%2 == 0) {
            for (int cOccurence : charOccurrence.values()) {
                if (cOccurence%2 != 0) {
                    return false;
                }
            }
        } else {
            int countOfOddOccurences = 0;
            for (int cOccurence : charOccurrence.values()) {
                if (cOccurence%2 != 0) {
                    if (++countOfOddOccurences > 1)
                        return false;
                }
            }
        }
        return true;
    }
}
