package org.paloalto.question1;

import java.util.Objects;

/**
 * Employee class
 * */
public class Employee extends Person {
    private final String role;
    public Employee(String name, int age, String role) {
        super(name, age);
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Employee)) return false;
        if (!super.equals(obj))
            return false;

        Employee employee = (Employee) obj;
        return Objects.equals(role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), role);
    }
}
