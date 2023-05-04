package com.taskmaster;

import java.util.*;

public class Commonality {
    public static List<String> mostCommonWords(List<String> listOfWords, int numOfWordsWanted){
        List<String> orderedWordList = sortDistinctWordsByCount(listOfWords);
        Collections.reverse(orderedWordList);
        return orderedWordList.subList(0,numOfWordsWanted);
    }

    public static Map<String, Integer> mapOfWordsToFrequency(List<String> listOfWords) {
        listOfWords.replaceAll(String::toLowerCase);
        listOfWords.sort(String::compareTo);

        Map<String, Integer> wordCount = new HashMap<>();

        listOfWords.stream().distinct()
                .forEach((word) -> {
                    int count = listOfWords.lastIndexOf(word) - listOfWords.indexOf(word) + 1;
                    wordCount.put(word,count);
                });
        return wordCount;
    }

    public static List<String> sortDistinctWordsByCount(List<String> listOfWords){
        List<String> uniqueWords = new ArrayList<>(listOfWords.stream().distinct().toList());
        Map<String, Integer> wordCount = mapOfWordsToFrequency(listOfWords);
        uniqueWords.sort(Comparator.comparing(wordCount::get));
        return uniqueWords;
    }

    public static List<String> leastCommonWords(List<String> listOfWords, int numOfWordsWanted){
        List<String> orderedWordList = sortDistinctWordsByCount(listOfWords);
        return orderedWordList.subList(0,numOfWordsWanted);
    }
}
