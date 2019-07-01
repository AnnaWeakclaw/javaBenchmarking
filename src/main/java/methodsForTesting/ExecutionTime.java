package main.java.methodsForTesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExecutionTime {



    public ArrayList calculateThetime(ArrayList arrayUnderTesting) {
        ArrayList durations = new ArrayList();
        for (int i = 0; i < 10; i++) {
            long startTime = System.nanoTime();
            //get last element
            arrayUnderTesting.get(arrayUnderTesting.size() - 1);
            long finishTime = System.nanoTime();

            long duration = finishTime - startTime;
            System.out.println("Time for last was: " + duration);
            durations.add(duration);

        }
    return durations;
    }

    ArrayList setTheArrayUp() {
        return new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    List setBiggerArray() {
        List<Integer> range = IntStream.rangeClosed(1, 10000)
                .boxed().collect(Collectors.toList());
        return range;
    }

    long finalTime(ArrayList durations) {
        CalculateMean mean = new CalculateMean();
        long theMean = mean.yourMeanIs(durations);
        return theMean;
    }

    void printMean(long mean) {
        System.out.println("Mean for time is: " + mean);
    }

    ArrayList calculateThetimeForreverse(ArrayList arrayUnderTesting) {
        ArrayList durations = new ArrayList();
        for (int i = 0; i < 10; i++) {
            long startTime = System.nanoTime();
            //reverse the array
            Collections.reverse(arrayUnderTesting);
            long finishTime = System.nanoTime();
            long duration = finishTime - startTime;
            System.out.println("Time for reverse was: " + duration);
            durations.add(duration);

        }
        return durations;
    }

    ArrayList calculateThetimeForShuffle(ArrayList arrayUnderTesting) {
        ArrayList durations = new ArrayList();
        for (int i = 0; i < 10; i++) {
            long startTime = System.nanoTime();
            //shuffle the array
            Collections.shuffle(arrayUnderTesting);
            long finishTime = System.nanoTime();
            long duration = finishTime - startTime;
            System.out.println("Time for shuffle was: " + duration);
            durations.add(duration);

        }
        return durations;
    }

    ArrayList calculateThetimeForSort(ArrayList arrayUnderTesting) {
        ArrayList durations = new ArrayList();
        Collections.shuffle(arrayUnderTesting);

        for (int i = 0; i < 10; i++) {
            long startTime = System.nanoTime();
            //sort the array
            Collections.sort(arrayUnderTesting);
            long finishTime = System.nanoTime();
            long duration = finishTime - startTime;
            System.out.println("Time for shuffle was: " + duration);
            durations.add(duration);

        }
        return durations;
    }
}
