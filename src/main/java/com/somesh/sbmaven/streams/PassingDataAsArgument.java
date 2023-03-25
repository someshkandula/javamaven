package com.somesh.sbmaven.streams;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PassingDataAsArgument {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool (5);

        executorService.submit (new Runnable () {
            @Override
            public void run() {
                System.out.println ("Calling runnable method as passing data as argument");
            }
        });


    }


}
