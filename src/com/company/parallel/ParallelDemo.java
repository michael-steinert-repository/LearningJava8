package com.company.parallel;

import java.util.stream.IntStream;

public class ParallelDemo {
    public static void main(String[] args) {
        long start = 0;
        long end = 0;

        start = System.currentTimeMillis();
        IntStream.range(1, 10).forEach(value -> System.out.println(value));
        end = System.currentTimeMillis();
        System.out.println(String.format("Plain Stream took Time: %s", (end - start)));

        /* The Parallel Streams have a random Order in Execution */
        start = System.currentTimeMillis();
        IntStream.range(1, 10).parallel().forEach(value -> System.out.println(value));
        end = System.currentTimeMillis();
        System.out.println(String.format("Plain Stream took Time: %s", (end - start)));

        IntStream.range(1, 10).forEach(value -> System.out.println(String.format("Thread: %s - Value: %s", Thread.currentThread().getName(), value)));

        IntStream.range(1, 10).parallel().forEach(value -> System.out.println(String.format("Thread: %s - Value: %s", Thread.currentThread().getName(), value)));
    }
}
