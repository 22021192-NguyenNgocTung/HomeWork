import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        Queue minQueue = new PriorityQueue<>() ;
        Queue maxQueue = new PriorityQueue<>(Collections.reverseOrder()) ;
        List<Double> ans = new ArrayList<>() ;
        for ( int i  = 0 ; i < a .size() ; i++){
            if ( minQueue.size() < maxQueue.size() ){
                minQueue.add(a.get(i)) ;
            }
            else {
                maxQueue.add(a.get(i)) ;
            }
            while (!minQueue.isEmpty()&&(int)minQueue.peek() < (int)maxQueue.peek()){
                int m1 = (int)minQueue.poll();
                int m2 = (int)maxQueue.poll();
                minQueue.add(m2);
                maxQueue.add(m1);
            }
            if (minQueue.size() == maxQueue.size()){
                double m1 = (int)minQueue.peek();
                double m2 = (int)maxQueue.peek();
                ans.add((m1 +m2)/2) ;
            }
            else {
                double m2 = (int)maxQueue.peek();
                ans.add(m2) ;
            }
        }
        return ans ;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
