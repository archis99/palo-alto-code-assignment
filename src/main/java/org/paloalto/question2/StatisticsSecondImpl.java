package org.paloalto.question2;

import org.paloalto.question2.Util.StatisticsException;
import org.paloalto.question2.Util.StatisticsUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * StatisticsSecondImpl test class
 * */
public class StatisticsSecondImpl implements Statistics  {

    private final ReentrantLock lock = new ReentrantLock(true);

    private volatile List<Integer> intStream;

    public StatisticsSecondImpl() {
        intStream = new ArrayList<>();
    }

    @Override
    public void event(int value) {
        lock.lock();
        try {
            intStream.add(value);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public float mean() {
        lock.lock();
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
        } finally {
            lock.unlock();
        }
        return mean;
    }

    @Override
    public int minimum() {
        lock.lock();
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
        } finally {
            lock.unlock();
        }
        return minimum;
    }

    @Override
    public int maximum() {
        lock.lock();
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
        } finally {
            lock.unlock();
        }
        return maximum;
    }

    @Override
    public float variance() {
        lock.lock();
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
        } finally {
            lock.unlock();
        }
        return variance;
    }
}
