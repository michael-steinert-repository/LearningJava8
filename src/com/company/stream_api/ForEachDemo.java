package com.company.stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ForEachDemo {
    /* Stream API is used to process Collections of Objects. */
    /* A Stream is a Sequence of Objects (Abstraction) that supports various Methods which can be pipelined to produce a Result */
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3);

        integerList.stream().forEach(integer -> System.out.println(String.format("Number %s", integer)));

        Map<Integer, String> integerStringMap = Arrays.asList(1, 2, 3).stream()
                .collect(Collectors.toMap(integer -> integer.intValue(), integer -> integer.toString()));

        integerStringMap.forEach((key, value) -> System.out.println(String.format("Key: %s - Value: %s", key, value)));

        integerStringMap.entrySet().stream().filter(integerStringEntry -> integerStringEntry.getKey() % 2 == 0)
                .forEach(integerStringEntry -> System.out.println(integerStringEntry));
    }
}
