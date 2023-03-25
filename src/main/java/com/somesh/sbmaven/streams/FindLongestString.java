package com.somesh.sbmaven.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindLongestString {

    public static void main(String[] args) {

        String[] data = {"java", "techie", "microservices", "springboot"};

        final String longestStringInAnArray = Arrays.stream (data)
                .reduce ((word1, word2) -> word1.length () > word2.length () ? word1 : word2)
                .get ();

        System.out.println ("longestStringInAnArray "+longestStringInAnArray);

        /* How to find the longest string from given array */
        final Map<Integer, String> collect = Arrays.stream (data)
                .collect (Collectors.toMap (s -> s.length (), s -> s));

        System.out.println ("collect  "+collect);

        Map<Integer, String> maxRecord = getMaxRecord(collect);


        System.out.println (" maxRecord "+maxRecord);


    }

    private static Map<Integer, String> getMaxRecord(Map<Integer, String> mapGroup) {
        if(mapGroup.isEmpty())
            return Collections.emptyMap ();
        long max = mapGroup.keySet ().stream().max(Comparator.naturalOrder()).get();
        return mapGroup.entrySet().stream()
                .filter(e -> e.getKey() == max)
                .collect(Collectors.toMap(k -> k.getKey (), k -> k.getValue ()));
    }
}
