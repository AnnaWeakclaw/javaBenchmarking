## This is an app that tests performance of methods and displays the results in a form of a graph

Java Backend runs a method under test n times, measures the time it takes to run the method each time, 
then it strips bottom&top n% resutls and takes a median time anyway.

Methods are tested on arrays of different sizes:
`shuffle`, `last`, `reverse`, `sort`.

Median time is calculated for arrays of different sizes(e.g. 100000, 150000, 250000,... ) 
and the corresponding times and sizes are being exported as a json file.

The file is then read by javascript that uses Chart.js to plot a graph.

TODO:
Refactor the java code, use Callable or a different mean to pass a method as a parameter
Refactor the javascript code to display all the graphs for all 4 methods
Find a solution to a problem where the json file is produced and not picked up by the js in a first run

----------------------------------------

On week10 - algorithms we learned about big O notation that describes complexity of an algorithm as a function graph.
We want our code to have operations of a constant time cost or maybe logarithmic or linear, definitely not quadratic.

My shuffle algorithm seems to have a linear performance time linear for the arrays of size < 505 000
and then the executions time seems to grow more quickly.

![ShuffleScreenshot](/src/main/resources/public/ShuffleScreenshot.png)

---
My implementation of `reverse` method:
```java
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

```
I think it has a linear complexity of O(n).
### My time graph:
![MyReverse](/src/main/resources/public/AnnasReverse.png)
### Inbuilt reverse method:
![JavaReverse](/src/main/resources/public/ReverseJava.png)