package org.paloalto.question2;

import org.paloalto.question2.Util.StatisticsException;
import org.paloalto.question2.Util.StatisticsUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * StatisticsImpl class
 * */
public class StatisticsImpl implements Statistics {

    private volatile List<Integer> intStream;

    public StatisticsImpl() {
        intStream = new ArrayList<>();
    }

    @Override
    public synchronized void event(int value) {
        intStream.add(value);
    }

    @Override
    public synchronized float mean() {
        float mean;
        try {
            float sum = intStream.stream().reduce(0, Integer::sum);
            mean = sum / intStream.size();
            if (Float.isNaN(mean)) throw new StatisticsException("Integer stream is empty.");
        } catch (StatisticsException e) {
            System.out.println("StatisticsException happened while getting mean");
            mean = StatisticsUtil.ZERO;
        } catch (Exception e) {
            System.out.println("Exception happened while getting mean");
            mean = StatisticsUtil.ZERO;
        }
        return mean;
    }

    @Override
    public synchronized int minimum() {
        int minimum = Integer.MAX_VALUE;
        try {
            for (int number: intStream) {
                if (number < minimum)
                    minimum = number;
            }
            if (minimum == Integer.MAX_VALUE) throw new StatisticsException("Integer stream is empty.");
        } catch (StatisticsException e) {
            System.out.println("StatisticsException happened while getting minimum");
            minimum = StatisticsUtil.ZERO;
        }  catch (Exception e) {
            System.out.println("Exception happened while getting minimum");
            minimum = StatisticsUtil.ZERO;
        }
        return minimum;
    }

    @Override
    public synchronized int maximum() {
        int maximum = Integer.MIN_VALUE;
        try {
            for (int number: intStream) {
                if (number > maximum)
                    maximum = number;
            }
            if (maximum == Integer.MIN_VALUE) throw new StatisticsException("Integer stream is empty.");
        } catch (StatisticsException e) {
            System.out.println("StatisticsException happened while getting maximum");
            maximum = StatisticsUtil.ZERO;
        }  catch (Exception e) {
            System.out.println("Exception happened while getting maximum");
            maximum = StatisticsUtil.ZERO;
        }
        return maximum;
    }

    @Override
    public float variance() {
        float variance;
        try {
            float mean = mean();
            float sum = StatisticsUtil.ZERO;
            for (int number: intStream) {
                sum += Math.pow(mean - number, StatisticsUtil.TWO);
            }
            variance = sum / intStream.size();
            if (Float.isNaN(variance)) throw new StatisticsException("Integer stream is empty.");
        } catch (StatisticsException e) {
            System.out.println("StatisticsException happened while getting variance");
            variance = StatisticsUtil.ZERO;
        } catch (Exception e) {
            System.out.println("Exception happened while getting variance");
            variance = StatisticsUtil.ZERO;
        }
        return variance;
    }
}
