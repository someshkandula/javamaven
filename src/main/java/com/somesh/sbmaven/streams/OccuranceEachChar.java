package com.somesh.sbmaven.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OccuranceEachChar {

    public static void main(String[] args) {
        String data = "ilovejavatechie";
        int k = 1;
        Map<Character, Integer> map = new HashMap ();

        for (int i=0;i<data.length ();i++){
            char c = data.charAt (i);
            if (map.containsKey (c) ){
                k = map.get(c);
                map.remove (c);
                map.put (c, k+1);
            } else {
                map.put (c, k);
            }
        }
        map.entrySet ().forEach (System.out::print);

        Map<String, List<String>> map1 = Arrays.stream (data.split ("")).collect (Collectors.groupingBy (s -> s));
        map1.entrySet ().forEach (System.out::println);

        System.out.println ("=========== Count ===========");
        // get the count of time char is repeated
        Map<String, Long> map2 = Arrays.stream (data.split ("")).collect (Collectors.groupingBy (s -> s, Collectors.counting ()));
        map2.entrySet ().forEach (System.out::println);

        Map<String, Long> map2Solution2 = Arrays.stream (data.split ("")).collect (Collectors.groupingBy (Function.identity (), Collectors.counting ()));
        map2Solution2.entrySet ().forEach (System.out::println);

        System.out.println (" Print Duplicate elements from the string");
        //Find the duplicate elements from the given string
         Arrays.stream (data.split (""))
                .collect (Collectors.groupingBy (Function.identity (), Collectors.counting ()))
                .entrySet ().stream().filter (x -> x.getValue () > 1).forEach (System.out::println);

         // Print only keys
        System.out.println ("Print duplicate elements keys only......");

        List<String> collect = Arrays.stream (data.split (""))
                .collect (Collectors.groupingBy (Function.identity (), Collectors.counting ()))
                .entrySet ().stream ()
                .filter (x -> x.getValue () > 1)
                .map (Map.Entry::getKey)
                .collect (Collectors.toList ());

        collect.stream ().forEach (System.out::println);

        System.out.println ("Print Unique elements key only......");

        List<String> uniqueElements = Arrays.stream (data.split (""))
                .collect (Collectors.groupingBy (Function.identity (), Collectors.counting ()))
                .entrySet ().stream ()
                .filter (x -> x.getValue () == 1)
                .map (Map.Entry::getKey)
                .collect (Collectors.toList ());

        System.out.println (uniqueElements);

        System.out.println ("Print First non repeatable element ......");

        String firstNonRepeatedElement = Arrays.stream (data.split (""))
                .collect (Collectors.groupingBy (Function.identity (), LinkedHashMap::new, Collectors.counting ()))
                .entrySet ()
                .stream ()
                .filter (x -> x.getValue () == 1)
                .findFirst ()
                .get ().getKey ();


        System.out.println (" firstNonRepeatedElement  "+firstNonRepeatedElement);

        String firstRepeatedElement = Arrays.stream (data.split (""))
                .collect (Collectors.groupingBy (Function.identity (), LinkedHashMap::new, Collectors.counting ()))
                .entrySet ()
                .stream ()
                .filter (x -> x.getValue () > 1)
                .findFirst ()
                .get ().getKey ();


        System.out.println (" firstRepeatedElement  "+firstRepeatedElement);




    }
}
