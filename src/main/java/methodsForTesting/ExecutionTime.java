package main.java.methodsForTesting;

import java.util.ArrayList;
import java.util.Collections;

public class ExecutionTime {


    public ArrayList calculateThetime(ArrayList arrayUnderTesting) {
        ArrayList durations = new ArrayList();
        for (int i = 0; i < 30; i++) {
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

    public long finalTime(ArrayList durations) {
        CalculateMedian median = new CalculateMedian();
        return median.yourMedianIs(durations);
    }

    void printMedian(long median) {
        System.out.println("Median for time is: " + median);
    }

    public ArrayList calculateThetimeForreverse(ArrayList arrayUnderTesting) {
        ArrayList durations = new ArrayList();
        for (int i = 0; i < 30; i++) {
            long startTime = System.nanoTime();
            //reverse the array
            myReverse(arrayUnderTesting);
            long finishTime = System.nanoTime();
            long duration = finishTime - startTime;
            System.out.println("Time for reverse was: " + duration);
            durations.add(duration);

        }
        return durations;
    }

    public ArrayList calculateThetimeForShuffle(ArrayList arrayUnderTesting) {
        ArrayList durations = new ArrayList();
        for (int i = 0; i < 30; i++) {
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

    public ArrayList calculateThetimeForSort(ArrayList arrayUnderTesting) {
        ArrayList durations = new ArrayList();
        ArrayList dontChangeMyArray = arrayUnderTesting;
        Collections.shuffle(arrayUnderTesting);

        for (int i = 0; i < 30; i++) {
            long startTime = System.nanoTime();
            //sort the array
            Collections.sort(arrayUnderTesting);
            long finishTime = System.nanoTime();
            long duration = finishTime - startTime;
            System.out.println("Time for sort was: " + duration);
            durations.add(duration);
            arrayUnderTesting = dontChangeMyArray;

        }
        return durations;
    }

    public ArrayList rejectTopAndBottom5Percent(ArrayList durations) {
        int length = durations.size();
        long whatToReject = Math.round(length * 0.1);
        System.out.println(whatToReject);
        Collections.sort(durations);
        for (int i = 0; i < whatToReject; i++) {
            durations.remove(0);
            durations.remove(durations.size() - 1);
        }
        return durations;
    }
//
//    public ArrayList myShuffle(ArrayList durations) {
//        Random random = ThreadLocalRandom.current();
//        for (int i = durations.size() - 1; i > 0; i--)
//        {
//            int index = random.nextInt(i + 1);
//            // Simple swap
//            int a = durations.;
//            durations[index] = durations[i];
//            durations[i] = a;
//        }
//
//        return durations;
//    }


    public ArrayList myReverse(ArrayList durations) {
        int nrOfElementsInArray = durations.size();
        int mySize = (nrOfElementsInArray % 2 == 0) ? nrOfElementsInArray / 2 : Math.round(nrOfElementsInArray / 2);

    for (int i = 0; i < mySize ; i++)
        {
            int forSwap = (int) durations.get(i);
            int valueOfTheElementFromTheEnd = (int) durations.get((nrOfElementsInArray - 1)- i);
            durations.set(i, valueOfTheElementFromTheEnd);
            durations.set(nrOfElementsInArray - 1 - i, forSwap);
        }

        return durations;
    }

}
