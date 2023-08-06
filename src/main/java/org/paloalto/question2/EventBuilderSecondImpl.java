package org.paloalto.question2;

public class EventBuilderSecondImpl {

    private final StatisticsSecondImpl statistics;
    public EventBuilderSecondImpl() {
        this.statistics = new StatisticsSecondImpl();
    }

    public EventBuilderSecondImpl addEvent(int value) {
        statistics.event(value);
        return this;
    }

    public StatisticsSecondImpl build() {
        return this.statistics;
    }
}
