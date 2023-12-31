package org.paloalto.question2;

public interface Statistics {
    /*
     * Called to update the statistic with a new sample value.
     */
    void event(int value);
    /*
     * Returns the mean of the received sample values.
     */
    float mean();
    /*
     * Returns the minimal received sample value.
     */
    int minimum();
    /*
     * Returns the maximal received sample value.
     */
    int maximum();
    /*
     * Returns an estimate of the variance of the total population
     * given the received sample values.
     */
    float variance();
}
