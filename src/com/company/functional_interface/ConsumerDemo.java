package com.company.functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    /* Consumer<T> is an inbuilt- functional Interface. */
    /* Consumer can be used in all Contexts where an Object needs to be consumed and no Return is needed. */
    public static void main(String[] args) {
        Consumer<Integer> integerConsumer = (t) -> {
            System.out.println(String.format("Accepted Argument %s", t));
        };

        integerConsumer.accept(42);

        List<Integer> integerList = Arrays.asList(1, 2, 3);

        /* The forEach()-Method calls internally the accept()-Method from the Consumer for each Element. */
        integerList.stream().forEach(integerConsumer);
    }
}
