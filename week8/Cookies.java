
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
class heap{
    public heap() {
    }
    public int getMin(){
        return a.get(0) ;
    }
    public List<Integer> a = new ArrayList<>();
    public int delMin(){
        exch(1 , a.size()) ;
        int ans = a.remove(a.size() - 1) ;
        sink(1);
        return ans ;
    }
    public void insert(int item){
        a.add(item) ;
        swim(a.size());
    }
    public void swim(int k){
        while ( k > 1 && less(k , k/2 )){
            exch(k , k/2);
            k = k/2 ;
        }
    }
    public void sink(int i ){
        while ( i * 2 <= a.size()){
            int j = i * 2 ;
            if (j < a.size() && less(j + 1,j )){
                j++ ;
            };
            if (!less(j,i)) break;
            exch( i ,j);
            i = j ;
        }
    }
    public boolean less(int i , int j ){
        return a.get(i - 1) < a.get(j - 1) ;
    }
    public void exch(int i , int j ){
        int tmp = a.get(i - 1) ;
        a.set(i - 1 , a.get(j -1)) ;
        a.set(j - 1 , tmp) ;
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
        heap arr = new heap() ;
        for ( int i = 0 ; i < A.size() ; i++){
            arr.insert(A.get(i));
        }
        int dem = 0 ;
        while (arr.getMin() < k && arr.a.size() >= 2) {
            int m1 = arr.delMin() ;
            int m2 = arr.getMin() ;
            arr.a.set(0 , m1 + 2 * m2) ;
            arr.sink(1);
            dem ++ ;
        }
        if (arr.getMin() < k){
            return -1 ;
        }
        else return dem ;
    }

}

public class Cookies {
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
