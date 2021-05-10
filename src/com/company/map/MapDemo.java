package com.company.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapDemo {
    /* map() and flatMap() are Methods that are intermediate and returns another Stream. */
    /* map()-Method is used for Transformation. It produces single Value for each Input Value (One-to-One Mapping). */
    /* map()-Method Signature: Stream<R> map(Stream<T> input){ } */
    /* flatMap()-Method is used for Transformation and Flattering. It produces multiple Values for each Input Value (One-to-Many Mapping). */
    /* flatMap()-Method Signature: Stream<R> map(Stream<Stream<T>> input){ } */
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person(List.of("Michael"), "Steinert"),
                new Person(List.of("Marie", "Anne"), "Schmidt"),
                new Person(List.of("Bruno"), "Schmidt")
        );

        /* Person -> Person.getLastName() One-to-One Mapping */
        List<String> lastNames = personList.stream().map(person -> person.getLastName()).collect(Collectors.toList());
        System.out.println(lastNames);

        /* Person -> Person.getFirstNames() One-to-Many Mapping */
        List<List<String>> firstNamesAsStreamOfStreams = personList.stream().map(person -> person.getFirstNames()).collect(Collectors.toList());
        System.out.println(firstNamesAsStreamOfStreams);

        List<String> firstNames = personList.stream().flatMap(person -> person.getFirstNames().stream()).collect(Collectors.toList());
        System.out.println(firstNames);
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
