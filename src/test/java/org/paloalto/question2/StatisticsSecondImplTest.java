package org.paloalto.question2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StatisticsSecondImplTest {
    static StatisticsSecondImpl statistics;

    @BeforeEach
    public void setUp() {
        statistics = new StatisticsSecondImpl();
    }

    @Test
    public void get_mean_success() {
        statistics.event(5);
        statistics.event(10);
        Assertions.assertEquals(7.5, statistics.mean());
    }

    @Test
    public void get_mean_failure_with_wrong_output() {
        statistics.event(5);
        statistics.event(10);
        Assertions.assertNotEquals(10, statistics.mean());
    }

    @Test
    public void get_mean_failure_with_no_event() {
        Assertions.assertEquals(0, statistics.mean());
    }

    @Test
    public void get_minimum_success() {
        statistics.event(35);
        statistics.event(34);
        Assertions.assertEquals(34, statistics.minimum());
    }

    @Test
    public void get_minimum_failure_with_wrong_output() {
        statistics.event(35);
        statistics.event(34);
        Assertions.assertNotEquals(35, statistics.minimum());
    }

    @Test
    public void get_minimum_failure_with_no_event() {
        Assertions.assertEquals(0, statistics.minimum());
    }

    @Test
    public void get_maximum_success() {
        statistics.event(5);
        statistics.event(15);
        Assertions.assertEquals(15, statistics.maximum());
    }

    @Test
    public void get_maximum_failure_with_wrong_output() {
        statistics.event(5);
        statistics.event(15);
        Assertions.assertNotEquals(5, statistics.maximum());
    }

    @Test
    public void get_maximum_failure_with_no_event() {
        Assertions.assertEquals(0, statistics.maximum());
    }

    @Test
    public void get_variance_success() {
        statistics.event(10);
        statistics.event(20);
        Assertions.assertEquals(25, statistics.variance());
    }

    @Test
    public void get_variance_failure_with_wrong_output() {
        statistics.event(10);
        statistics.event(20);
        Assertions.assertNotEquals(10, statistics.variance());
    }

    @Test
    public void get_variance_failure_with_no_event() {
        Assertions.assertEquals(0, statistics.variance());
    }

}
