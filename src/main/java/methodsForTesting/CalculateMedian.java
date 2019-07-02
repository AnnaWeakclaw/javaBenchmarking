package main.java.methodsForTesting;

import java.util.ArrayList;

public class CalculateMedian {

    public long yourMedianIs(ArrayList<Long> sortedArrayOfNumbers) {
        if (sortedArrayOfNumbers.size() % 2 == 0)
           return (sortedArrayOfNumbers.get(sortedArrayOfNumbers.size() / 2) + sortedArrayOfNumbers.get(sortedArrayOfNumbers.size() / 2 - 1)) / 2;
        else
            return sortedArrayOfNumbers.get(sortedArrayOfNumbers.size() / 2);

    }
}
