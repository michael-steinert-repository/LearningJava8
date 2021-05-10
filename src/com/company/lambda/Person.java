package com.company.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person implements IPerson {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /* Approach without Lambda Expression */

    @Override
    public String getFullName(String firstName, String lastName) {
        return String.format("%s %s",firstName, lastName);
    }

    /* Approach with Lambda Expression */
    /* Class do not need to implement the Interface */
    /* Lambda Expression: Expression through which we can represent an anonymous Function - it can only be applied on functional Interfaces */
    /* Anonymous Function: a Method, that do not have any Name or Modifier */
    /* Functional Interface: Interface, who contains only one abstract Method, but can have multiple default static Methods */
    IPerson iPerson = (String firstName, String lastName) -> {
        return String.format("%s %s",firstName, lastName);
    };

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "FirstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", FullName =" + iPerson.getFullName(firstName, lastName) +
                '}';
    }


    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("Michael", "Steinert"),
                new Person("Marie", "Schmidt"),
                new Person("Bruno", "Schmidt")
        );

        System.out.println(personList);

        /* Approach without Lambda Expression */
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        });

        /* Approach with Lambda Expression */
        Collections.sort(personList, (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));

        System.out.println(personList);
    }
}
