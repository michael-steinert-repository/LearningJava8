package com.company.optional;

import java.util.List;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        Person person = new Person(List.of("Michael"), null);

        /* of()-Method do an internally Null Check. */
        Optional<List<String>> firstNamesOptional = Optional.of(person.getFirstNames());
        if (firstNamesOptional.isPresent()) {
            System.out.println(firstNamesOptional.stream());
        }

        Optional<String> lastNameOptional = Optional.ofNullable(person.getLastName());
        if (lastNameOptional.isEmpty()) {
            System.out.println(lastNameOptional.map(s -> s.toUpperCase()).orElse("Lastname is empty."));
        }
    }

    private static class Person {
        private List<String> firstNames;
        private String lastName;

        public Person(List<String> firstNames, String lastName) {
            this.firstNames = firstNames;
            this.lastName = lastName;
        }

        public List<String> getFirstNames() {
            return firstNames;
        }

        public String getLastName() {
            return lastName;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "FirstName='" + firstNames + '\'' +
                    ", LastName='" + lastName + '\'' +
                    '}';
        }
    }
}
