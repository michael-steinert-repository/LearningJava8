package com.company.stream_api;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortDemo {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(2, 1, 3);

        integerList.stream().sorted(Comparator.reverseOrder()).forEach(integer -> System.out.println(integer));

        integerList.stream().sorted((o1, o2) -> o1.intValue() - o2.intValue()).forEach(integer -> System.out.println(integer));
    }
}
