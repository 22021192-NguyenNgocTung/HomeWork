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

class Pair implements Comparable<Pair>{
    int value;
    int index ;

    public Pair(int val, int i) {
        this.value = val ;
        this.index = i ;
    }
    @Override
    public int compareTo(Pair o) {
        if (this.value < o.value){
            return -1;
        }
        else if (this.value > o.value){
            return 1 ;
        }
        else {
            return Integer.compare(index, o.index);
        }
    }
}
class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static TreeSet<Pair> treeSet = new TreeSet<>();
    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        TreeSet <Pair> higher = new TreeSet<>() ;
        TreeSet <Pair> lower = new TreeSet<>() ;
        List<Double> list = new ArrayList<>();
        for ( int i = 0 ; i < a.size() ; i++){
            if (higher.size() > lower.size()){
                lower.add(new Pair(a.get(i) , i));
            }
            else {
                higher.add(new Pair(a.get(i) , i));
            }
            while (!lower.isEmpty() && higher.first().compareTo(lower.last()) < 0 ){
                Pair p1 = higher.pollFirst();
                Pair p2 = lower.pollLast();
                higher.add(p2);
                lower.add(p1);
            }
            if (higher.size() > lower.size()){
                list.add(higher.first().value / 1.0);
            }
            else {
                list.add(1.0 * (higher.first().value + lower.last().value)/2);
            }
        }
        return list;
    }
}

public class MedianTreeSet {
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
