package com.somesh.sbmaven.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntElementStartWith {

    public static void main(String[] args) {
        int[] numbers = {5,9,11,2,2,21,1,111};
        /*final List<Integer> collect = Arrays.stream (numbers).boxed ()
                .reduce ((b,c) -> ( b.intValue () % 1 == 1 || c.intValue () % 1 == 1 ) ? b.intValue () : c.intValue ())
                        .stream().toList ();
        System.out.println (collect);*/

        final List<String> collect1 = Arrays.stream (numbers).boxed ()
                .map (s -> s + "")
                .filter (s -> s.startsWith ("1"))
                .collect (Collectors.toList ());

        System.out.println (collect1);


        /* String.join method example  */

        List<String> nos = Arrays.asList ("1","2","3","4");

        final String collect = nos.stream ().collect (Collectors.joining ("-"));

        String joinedList = String.join ("-", nos);
        System.out.println (collect);
        System.out.println (joinedList);


        //.anyMatch (e -> e.toString ().startsWith ("1"));
        //System.out.println(b);
    }
}
