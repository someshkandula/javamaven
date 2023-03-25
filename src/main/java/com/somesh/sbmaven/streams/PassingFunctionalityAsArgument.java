package com.somesh.sbmaven.streams;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;

public class PassingFunctionalityAsArgument {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool (2);


        Runnable processFlow = new Runnable () {
            @Override
            public void run() {
                System.out.println ("executing the anonymous inner class as an argument");
            }
        };

        Runnable processFlow1 = () -> { System.out.println ("Write the logic here, Lambda making code short and easy"); };

        executorService.submit (processFlow);
        executorService.submit (processFlow1);
    }
}
