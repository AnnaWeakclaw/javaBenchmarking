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

//        System.out.println(myArrays.giveMedianForArraySizes(5000, 100000, 10000, effectiveAlgorithms));

        HashMap trialData = myArrays.giveMedianForArraySizes(5000, 1000000, 100000, effectiveAlgorithms);
        System.out.println("R-------------------");
//effectiveAlgorithms.testMethod(array);
        //how do I wait for the file to be updated?
        get("/hello", "application/json", (request, response) -> {
            returnMyJson(trialData);
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
        objectMapper.writeValue(new File("src/main/resources/public/js/mymap.json"), myData );
    }

}