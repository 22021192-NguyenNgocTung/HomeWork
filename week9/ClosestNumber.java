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
class MergeSort {
    public static void merge(int[] a, int[] arr, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            arr[i] = a[i];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = arr[j++];
            else if (j > hi) a[k] = arr[i++];
            else if (arr[i] > arr[j]) a[k] = arr[j++];
            else a[k] = arr[i++];
        }
    }
    public static void sort(int[] a , int[] arr , int lo , int hi){
        if ( lo >= hi){
            return;
        }
        int mid = lo + (hi - lo) /2 ;
        sort(a,arr,lo,mid);
        sort(a,arr,mid+1,hi);
        merge(a,arr,lo,mid,hi);
    }
    public static void sort(int[] a , int lo, int hi){
        int[] arr = new int[a.length];
        sort(a,arr,lo,hi);
    }
}
class Result {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {

        int[] a = new int[arr.size()];
        for ( int i = 0 ; i < arr.size(); i++){
            a[i] = arr.get(i);
        }
        MergeSort.sort(a,0,a.length-1);
        for ( int i = 0 ; i < arr.size() ; ++i){
            arr.set(i,a[i]) ;
        }
        int check = arr.get(1) - arr.get(0) ;
        for ( int i = 1 ; i < arr.size() - 1 ; ++i){
            if ( (arr.get(i + 1) - arr.get(i)) < check ){
                check = arr.get(i + 1) - arr.get(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        for ( int i = 0 ; i < arr.size() - 1 ; ++i){
            if ( (arr.get(i + 1) - arr.get(i)) == check){
                list.add(arr.get(i)) ;
                list.add(arr.get(i+1));
            }
        }
        return list ;

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

        List<Integer> result = Result.closestNumbers(arr);

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
