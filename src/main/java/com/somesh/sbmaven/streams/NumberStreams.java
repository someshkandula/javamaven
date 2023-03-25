package com.somesh.sbmaven.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberStreams {

    public static void main(String[] args) {

        int[] numbers = {5,9,11,2,8,21,1};

        OptionalInt first;
        first = IntStream.of (numbers)
                .sorted ()
                .limit (2)
                .skip (1)
                .findFirst ();
        System.out.println (first);

        List<Integer> integerList = Arrays.stream (numbers).boxed ()
                .sorted (Comparator.reverseOrder ())
                .limit (2)
                .skip (1)
                .collect (Collectors.toList ());
        System.out.println (integerList);


        int secondHighestValue  = Arrays.stream (numbers).boxed ()
                .sorted (Comparator.reverseOrder ())
                .skip (1)
                .findFirst ()
                .get ().
                intValue ();

        System.out.println ("secondHighestValue :: "+secondHighestValue);

        int secondLowestValue  = Arrays.stream (numbers).boxed ()
                .sorted ()
                .skip (1)
                .findFirst ()
                .get ().
                intValue ();

        System.out.println ("secondLowestValue :: "+secondLowestValue);

    }
}
