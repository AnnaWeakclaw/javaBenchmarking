package main.java.methodsForTesting;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static spark.Spark.*;

public class FindTime {


    public static void main(String[] args) throws IOException {
        staticFiles.location("/public");

        ExecutionTime effectiveAlgorithms = new ExecutionTime();
        SizeArrayPrinter myArrays = new SizeArrayPrinter();
        ArrayList array = (ArrayList) myArrays.setBiggerArray(10000);

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

        System.out.println(myArrays.giveMedianForArraySizes(5000, 50000, 5000, effectiveAlgorithms));

        HashMap trialData = myArrays.giveMedianForArraySizes(5000, 50000, 5000, effectiveAlgorithms);

        returnMyJson(trialData);
        get("/hello", "application/json", (request, response) -> {
            response.redirect("/index.html");
            return null;
        });

    }

    private static void giveMedian(ExecutionTime effectiveAlgorithms, ArrayList durationsForMethod) {
        long median = effectiveAlgorithms.finalTime(durationsForMethod);
        effectiveAlgorithms.printMedian(median);
        System.out.println("*******************");
    }
    public static void returnMyJson(HashMap myData) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("map.json"), myData );
    }

}