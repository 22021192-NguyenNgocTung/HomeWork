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
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        int tmp = partition(arr, 0 , arr.size() - 1) ;
        while ( tmp != arr.size()/2) {
            if ( tmp < arr.size() /2 ){
                tmp = partition(arr, tmp + 1 , arr.size() - 1) ;
            }
            else {
                tmp = partition(arr, 0 , tmp - 1);
            }
        }
        return arr.get(tmp) ;
    }
    public static int partition(List<Integer> arr , int lo , int hi){
            int i = lo , j = hi + 1;
            while ( true) {
                while ( arr.get(++i) < arr.get(lo)) {
                    if ( i == hi) break ;
                }
                while ( arr.get(--j) > arr.get(lo)) {
                    if (j == lo) break;
                }
                if ( i >= j) break ;
                else {
                    int tmp = arr.get(i) ;
                    arr.set(i , arr.get(j)) ;
                    arr.set(j , tmp)  ;
                }
            }
            int tmp = arr.get(lo) ;
            arr.set(lo , arr.get(j)) ;
            arr.set(j , tmp)  ;
            return j ;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.findMedian(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
