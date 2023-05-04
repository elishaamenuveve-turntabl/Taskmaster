package com.taskmaster;

public class Heterogram {
    public static boolean isHeterogram(String word){
        word =  word.replaceAll(" ", "").toLowerCase();

        for(char c : word.toCharArray()) {
            if(word.indexOf(c) != word.lastIndexOf(c)) {
                return false;
            }
        }
        return true;
    }
}
