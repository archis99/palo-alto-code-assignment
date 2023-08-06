package org.paloalto;

import org.paloalto.question1.Employee;
import org.paloalto.question1.Person;
import org.paloalto.question2.EventBuilder;
import org.paloalto.question2.EventBuilderSecondImpl;
import org.paloalto.question2.StatisticsImpl;
import org.paloalto.question2.StatisticsSecondImpl;

/**
 * Main class
 * */
public class Main {
    public static void main(String[] args) {
        // To test Question 1
        testQuestion1();
        // To test Question 2
        testQuestion2();
        // To test Question 2 second impl.
        // testQuestion2SecondImpl();
    }

    public static void testQuestion1() {
        Person p1 = new Person("John", 20);
        Person p2 = new Person("John", 20);

        Employee e1 = new Employee("John", 20, "Admin");
        Employee e2 = new Employee("John", 20, "Admin");

        System.out.println(p1.equals(p2));
        System.out.println(e1.equals(e2));

        System.out.println(e1.equals(p1));
        System.out.println(p1.equals(e2));
    }

    public static void testQuestion2() {
        Thread t1 = new Thread(() -> {
            EventBuilder eventBuilder = new EventBuilder();
            StatisticsImpl statistics = eventBuilder.addEvent(600).addEvent(470).addEvent(170)
                    .addEvent(430).addEvent(300).build();

            System.out.println("Max: " + statistics.maximum());
            System.out.println("Min: " + statistics.minimum());
            System.out.println("Mean: " + statistics.mean());
            System.out.println("Variance: " + statistics.variance());
        });

        Thread t2 = new Thread(() -> {
            EventBuilder eventBuilder = new EventBuilder();
            StatisticsImpl statistics = eventBuilder.addEvent(6).addEvent(47).addEvent(17)
                    .addEvent(43).addEvent(3).build();

            System.out.println("Max: " + statistics.maximum());
            System.out.println("Min: " + statistics.minimum());
            System.out.println("Mean: " + statistics.mean());
            System.out.println("Variance: " + statistics.variance());
        });

        t1.start();
        t2.start();
    }

    public static void testQuestion2SecondImpl() {
        Thread t1 = new Thread(() -> {
            EventBuilderSecondImpl eventBuilder = new EventBuilderSecondImpl();
            StatisticsSecondImpl statistics = eventBuilder.addEvent(600).addEvent(470).addEvent(170)
                    .addEvent(430).addEvent(300).build();

            System.out.println("Max: " + statistics.maximum());
            System.out.println("Min: " + statistics.minimum());
            System.out.println("Mean: " + statistics.mean());
            System.out.println("Variance: " + statistics.variance());
        });

        Thread t2 = new Thread(() -> {
            EventBuilderSecondImpl eventBuilder = new EventBuilderSecondImpl();
            StatisticsSecondImpl statistics = eventBuilder.addEvent(6).addEvent(47).addEvent(17)
                    .addEvent(43).addEvent(3).build();

            System.out.println("Max: " + statistics.maximum());
            System.out.println("Min: " + statistics.minimum());
            System.out.println("Mean: " + statistics.mean());
            System.out.println("Variance: " + statistics.variance());
        });

        t1.start();
        t2.start();
    }
}