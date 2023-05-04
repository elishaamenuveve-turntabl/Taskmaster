package com.taskmaster;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> listOfWords = new ArrayList<>(List.of("Hi", "hI", "BE", "BeE", "Set", "sent", "be", "pop", "pip", "pip"));
        System.out.println(Commonality.mapOfWordsToFrequency(listOfWords));
    }
}