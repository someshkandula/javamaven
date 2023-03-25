package com.somesh.sbmaven.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class IntStreamExample {

    public static void main(String[] args) {
        int[] numbers = {10,3,4,6,12,34,21};

        // Tradition approach

        int min = numbers[0];

        for(int i=1;i<numbers.length;i++){
            if(min > numbers[i]){
                min = numbers[i];
            }
        }
        System.out.println (" Traditional code output :: "+min);

        // Java 8 Streams

        int minimum = IntStream.of (numbers).min ().getAsInt ();

        System.out.println (" Stream Output :: "+minimum);
        System.out.println (" Stream Output :: "+IntStream.of (numbers).max ().getAsInt ());
        System.out.println (" Stream Output :: "+IntStream.of (numbers).average ().getAsDouble ());
        System.out.println (" Stream Output :: "+IntStream.of (numbers).count ());
        System.out.println (" Stream Output :: "+IntStream.of (numbers).sum ());

        // Instead of creating streams every time, you can create summaryStatistics
        IntSummaryStatistics summaryStatistics = IntStream.of(numbers).summaryStatistics ();
        System.out.println (summaryStatistics.getMin ());
        System.out.println (summaryStatistics.getMax ());
        System.out.println (summaryStatistics.getAverage ());
        System.out.println (summaryStatistics.getCount ());
        System.out.println (summaryStatistics.getSum ());


        int[] firstThreeNumbers = {2,40,23,56,32,12,4,7,8,2};

        int[] copy = Arrays.copyOf (firstThreeNumbers, firstThreeNumbers.length);

        Arrays.sort(copy);

        System.out.println ("===========");
        for(int k=0;k<3;k++){
            System.out.println (copy[k]);
        }

        System.out.println ("===========");
        IntStream.of(firstThreeNumbers).distinct ()
                .sorted ()
                .limit (3)
                .forEach (System.out::println);

        System.out.println ("===========");

        String[] strArr = {"Orange","Grape","Apple","Bannana","Pineapple","Water melon"};

        Arrays.stream(strArr)
                .distinct ()
                .sorted ()
                .limit (3)
                .forEach (System.out::println);

    }
}
