package main.java.methodsForTesting;

import java.util.ArrayList;

class CalculateMean {

    long yourMeanIs(ArrayList<Long> arrayOfNumbers) {
        long sum = 0;
        for (long number : arrayOfNumbers) {
            sum += number;
        }
        return (long) Math.round(sum / arrayOfNumbers.size());
    }
}
