package main.java.methodsForTesting;

import java.util.ArrayList;

public class FindTime {


    public static void main(String[] args) {

        ExecutionTime effectiveAlgorithms = new ExecutionTime();
        ArrayList array = (ArrayList) effectiveAlgorithms.setBiggerArray();

        ArrayList durationsForLast = effectiveAlgorithms.calculateThetime(array);
        ArrayList trimmedResultsForLast = effectiveAlgorithms.rejectTopAndBottom5Percent(durationsForLast);
        giveMedian(effectiveAlgorithms, trimmedResultsForLast);

        ArrayList durationsForReverse = effectiveAlgorithms.calculateThetimeForreverse(array);
        ArrayList trimmedResultsForReverse = effectiveAlgorithms.rejectTopAndBottom5Percent(durationsForReverse);
        giveMedian(effectiveAlgorithms, trimmedResultsForReverse);

        ArrayList durationsForShuffle = effectiveAlgorithms.calculateThetimeForShuffle(array);
        ArrayList trimmedResultsForShuffle = effectiveAlgorithms.rejectTopAndBottom5Percent(durationsForShuffle);
        giveMedian(effectiveAlgorithms, trimmedResultsForShuffle);

        ArrayList durationsForSort = effectiveAlgorithms.calculateThetimeForSort(array);
        ArrayList trimmedResultsForSort = effectiveAlgorithms.rejectTopAndBottom5Percent(durationsForSort);
        System.out.println(trimmedResultsForSort);
        giveMedian(effectiveAlgorithms, trimmedResultsForSort);

    }

    private static void giveMedian(ExecutionTime effectiveAlgorithms, ArrayList durationsForMethod) {
        long median = effectiveAlgorithms.finalTime(durationsForMethod);
        effectiveAlgorithms.printMedian(median);
        System.out.println("*******************");
    }


}