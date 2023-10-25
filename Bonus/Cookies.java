
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
class Sort_Heap{
    public int[] arr  ;

    public Sort_Heap() {
        arr = new int[1000001];
        n = 0 ;
    }

    public int n ;
    public void insert(int item){
        arr[++n] = item ;
        swim(n);
    }
    public void swim(int k){
        while ( k > 1 && arr[k] < arr[k/2] ){
            int tmp = arr[k] ;
            arr[k] = arr[k/2] ;
            arr[k/2] =tmp ;
            k = k/2 ;
        }
    }
    public int getMin(){
        return arr[1] ;
    }
    public int deleteMin(){
        int ans = arr[1] ;
        arr[1] = arr[n--] ;
        sink(1);
        return ans ;
    }
    public void sink(int k){
        while (k*2 <= n){
            int j = k*2 ;
            if ( j < n && arr[j+1] < arr[j]) j++ ;
            if (arr[j] >arr[k]) break ;
            int tmp = arr[j] ;
            arr[j] = arr[k] ;
            arr[k] = tmp ;
            k = j ;
        }
    }
    public int size(){
        return n ;
    }
}
class Result {

    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */

    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        Sort_Heap pqqueHeap = new Sort_Heap();
        for ( int i = 0 ; i < A.size() ; i++){
            pqqueHeap.insert(A.get(i)) ;
        }
        int dem = 0 ;
        while (pqqueHeap.size() >= 2 && pqqueHeap.getMin() < k){
            int m1 = pqqueHeap.deleteMin();
            int m2 = pqqueHeap.deleteMin();
            pqqueHeap.insert(m1 + 2* m2) ;
            dem ++;
        }
        if (pqqueHeap.getMin() < k){
            return -1 ;
        }
        else {
            return dem ;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
