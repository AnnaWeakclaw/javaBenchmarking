package main.java.methodsForTesting;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.methodsForTesting.ExecutionTime;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SizeArrayPrinter {



    ArrayList setTheArrayUp() {
        return new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    public List setBiggerArray(int howBig) {
        List<Integer> range = IntStream.rangeClosed(1, howBig)
                .boxed().collect(Collectors.toList());
        return range;
    }

    public HashMap<Integer, Long> giveMedianForArraySizes(int startHere, int finishHere, int step, ExecutionTime executionTime) {
        HashMap<Integer, Long> medianTimeToSize = new HashMap<>();

        for (int i = startHere; i <= finishHere; i += step) {
            ArrayList array = (ArrayList) setBiggerArray(i);
            ArrayList durations = executionTime.calculateThetime(array);

            ArrayList trimmedDurations = executionTime.rejectTopAndBottom5Percent(durations);
            long medianTime = executionTime.finalTime(trimmedDurations);
            medianTimeToSize.put(i, medianTime);
        }

        return medianTimeToSize;
    }

}
