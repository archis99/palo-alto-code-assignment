package org.paloalto.question2.Util;

public class StatisticsException extends Exception {

    public StatisticsException () {
        super();
    }

    public StatisticsException (String errorMessage) {
        super(errorMessage);
    }

    public StatisticsException (String errorMessage, Throwable e) {
        super(errorMessage, e);
    }
}
