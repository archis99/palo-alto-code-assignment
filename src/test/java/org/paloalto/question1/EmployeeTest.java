package org.paloalto.question1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Employee test class
 * */
public class EmployeeTest {

    static Employee employee;

    @BeforeEach
    public void setUp() {
        employee = new Employee("John", 20, "Admin");
    }

    @Test
    public void equal_employee_object() {
        Employee similarEmployee = new Employee("John", 20, "Admin");
        Assertions.assertTrue(employee.equals(similarEmployee));
        Assertions.assertTrue(similarEmployee.equals(employee));
        Assertions.assertEquals(employee.hashCode(), similarEmployee.hashCode());
    }

    @Test
    public void unequal_employee_object() {
        Employee anotherEmployee = new Employee("John", 25, "User");
        Assertions.assertFalse(employee.equals(anotherEmployee));
        Assertions.assertFalse(anotherEmployee.equals(employee));
        Assertions.assertNotEquals(employee.hashCode(), anotherEmployee.hashCode());
    }

    @Test
    public void unequal_employee_person_object() {
        Person person = new Person("John", 20);
        Assertions.assertFalse(employee.equals(person));
        Assertions.assertFalse(person.equals(employee));
        Assertions.assertNotEquals(employee.hashCode(), person.hashCode());
    }

}
