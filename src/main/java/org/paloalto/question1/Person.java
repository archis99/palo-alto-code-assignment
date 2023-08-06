package org.paloalto.question1;

import java.util.Objects;

/**
 * Person class
 * */
public class Person {
    private final int age;
    private final String name;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Person))
            return false;
        if (obj.getClass() != this.getClass())
            return false;

        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
