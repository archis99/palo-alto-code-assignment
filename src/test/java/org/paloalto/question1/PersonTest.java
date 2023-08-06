package org.paloalto.question1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Person test class
 * */
public class PersonTest {

    static Person person;

    @BeforeEach
    public void setUp() {
        person = new Person("John", 20);
    }

    @Test
    public void equal_person_object() {
        Person similarPerson = new Person("John", 20);
        Assertions.assertTrue(person.equals(similarPerson));
        Assertions.assertTrue(similarPerson.equals(person));
        Assertions.assertEquals(person.hashCode(), similarPerson.hashCode());
    }

    @Test
    public void unequal_person_object() {
        Person anotherPerson = new Person("John", 25);
        Assertions.assertFalse(person.equals(anotherPerson));
        Assertions.assertFalse(anotherPerson.equals(person));
        Assertions.assertNotEquals(person.hashCode(), anotherPerson.hashCode());
    }

    @Test
    public void unequal_person_employee_object() {
        Employee employee = new Employee("John", 20, "Admin");
        Assertions.assertFalse(person.equals(employee));
        Assertions.assertFalse(employee.equals(person));
        Assertions.assertNotEquals(person.hashCode(), employee.hashCode());
    }
}
