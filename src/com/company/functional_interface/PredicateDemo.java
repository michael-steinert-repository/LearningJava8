package com.company.functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
    /* Predicate<T> is an inbuilt- functional Interface. */
    /* Predicate can be used for conditional Checks and returns True or False. */
    public static void main(String[] args) {
        Predicate<Integer> integerPredicate = (t) -> {
            if (t % 2 == 0) {
                return true;
            }
            return false;
        };

        int number = 42;

        boolean isEven = integerPredicate.test(number);

        System.out.println(String.format("Number %s is even: %s", number, isEven));

        List<Integer> integerList = Arrays.asList(1, 2, 3);

        /* The filter()-Method used a conditional Checks to each Element of a Stream. */
        integerList.stream().filter(integerPredicate).forEach(integer -> System.out.println(String.format("Number %s is even", integer)));
    }
}
