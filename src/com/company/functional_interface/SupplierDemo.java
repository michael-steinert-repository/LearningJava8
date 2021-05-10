package com.company.functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {
    /* Supplier<T> is an inbuilt- functional Interface. */
    /* Supplier can be used in Contexts where there is no Input but an Output expected. */
    public static void main(String[] args) {
        Supplier<Integer> integerSupplier = () -> {
            return 42;
        };

        System.out.println(String.format("Number from Supplier %s", integerSupplier.get()));

        List<Integer> integerList = Arrays.asList(1, 2, 3);

        /* The forEach()-Method calls internally the accept()-Method from the Consumer for each Element. */
        Integer integer = integerList.stream().findAny().orElseGet(integerSupplier);

        System.out.println(String.format("Number from List: %s", integer));
    }
}
