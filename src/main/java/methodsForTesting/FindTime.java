package main.java.methodsForTesting;

import java.util.ArrayList;
import java.util.Arrays;

public class FindTime {


    public static void main(String[] args) {

        ExecutionTime effectiveAlgorithms = new ExecutionTime();
        ArrayList array = (ArrayList) effectiveAlgorithms.setBiggerArray();

        ArrayList durationsForLast = effectiveAlgorithms.calculateThetime(array);
        giveMean(effectiveAlgorithms, durationsForLast);

        ArrayList durationsForReverse = effectiveAlgorithms.calculateThetimeForreverse(array);
        giveMean(effectiveAlgorithms, durationsForReverse);

        ArrayList durationsForShuffle = effectiveAlgorithms.calculateThetimeForShuffle(array);
        giveMean(effectiveAlgorithms, durationsForShuffle);

        ArrayList durationsForSort = effectiveAlgorithms.calculateThetimeForSort(array);
        giveMean(effectiveAlgorithms, durationsForSort);

    }

    private static void giveMean(ExecutionTime effectiveAlgorithms, ArrayList durationsForMethod) {
        long mean = effectiveAlgorithms.finalTime(durationsForMethod);
        effectiveAlgorithms.printMean(mean);
        System.out.println("*******************");
    }


}