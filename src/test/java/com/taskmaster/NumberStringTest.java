package com.taskmaster;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberStringTest {

    @Test
    void returnsTheHighestGroupValueInList() {
        List<String> numberList = new ArrayList<>(List.of("1", "2", "", "40", "2","","6", "34", "5", "","45", "2")
        );
        Assertions.assertEquals(47.0, NumberString.getHighestValuedGroupIn(numberList));
    }

    @Test
    void  returnsZeroForEmptyString() {
        List<String> numberList = new ArrayList<>(List.of("", "","")
        );
        Assertions.assertEquals(0.0, NumberString.getHighestValuedGroupIn(numberList));
    }

}