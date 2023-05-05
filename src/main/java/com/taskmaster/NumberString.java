package com.taskmaster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NumberString {

    public static double getHighestValuedGroupIn(List<String> stringList) {

        stringList.add("");
        int sumOfHighestGroup = 0;
        int sumOfCurrentGroup = 0;
        for (String string : stringList) {
            if (Objects.equals(string, "")) {
                if ( sumOfCurrentGroup > sumOfHighestGroup) {
                    sumOfHighestGroup = sumOfCurrentGroup;
                }
                sumOfCurrentGroup = 0;
            } else {
                sumOfCurrentGroup += Integer.parseInt(string);
            }
        }
        return sumOfHighestGroup;
    }
}
