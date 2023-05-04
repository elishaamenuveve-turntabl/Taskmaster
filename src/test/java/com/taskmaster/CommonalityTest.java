package com.taskmaster;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommonalityTest {

    @Test
    void returnsWordsCorrectlyOrderedByOccurence() {
        List<String> orderedList =
                new ArrayList<>(
                        List.of("one", "two", "two", "three", "three", "three")
                );
        List<String> unorderdList = new ArrayList<>(List.copyOf(orderedList));
        Collections.shuffle(unorderdList);
        List<String> actual = Commonality.sortDistinctWordsByCount(unorderdList);
        Assertions.assertEquals(orderedList.stream().distinct().toList(), actual);
    }
}