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
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        int[] a = new int[100];
        List <Integer> list = new ArrayList<>() ;
        for ( int i = 0 ; i < 100 ; i++){
            a[i] = 0 ;
        }
        int min = brr.get(0);
        for ( int i = 0 ; i < brr.size() ; i++){
            if (brr.get(i) < min){
                min = brr.get(i);
            }
        }
        for ( int i = 0 ; i < brr.size() ; i++){
            a[brr.get(i) - min]++ ;
        }
        for ( int i = 0 ; i < arr.size() ; i++){
            a[arr.get(i) - min] --;
        }
        for ( int i = 0 ; i< 100 ; i++){
            if (a[i] > 0){
                list.add(i+min) ;
            }
        }
        Collections.sort(list);
        return list ;
    }

}

public class Counting {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.missingNumbers(arr, brr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
