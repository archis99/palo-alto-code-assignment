package org.paloalto.question2;

/**
 * Event builder class
 * */
public class EventBuilder {

    private final StatisticsImpl statistics;
    public EventBuilder() {
        this.statistics = new StatisticsImpl();
    }

    public EventBuilder addEvent(int value) {
        statistics.event(value);
        return this;
    }

    public StatisticsImpl build() {
        return this.statistics;
    }
}
