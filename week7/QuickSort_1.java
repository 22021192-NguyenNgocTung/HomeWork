package main.week7;

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
    public static List<Integer> quickSort(List<Integer> arr) {
        // Write your code here
        int i = 0 , j = arr.size() ;
        while(true) {
            while (arr.get(++i) <= arr.get(0) ){
                if ( i == arr.size() -1) break ;
            }
            while (arr.get(--j) > arr.get(0)) {
                if ( j == 0) break ;
            }
            if ( i >= j) break ;
            exch(arr, i , j) ;

        }
        exch(arr , 0 , j) ;
        return arr ;
    }
    public static void exch(List<Integer> arr , int i , int j ){
        int a = arr.get(i) ;
        arr.set(i , arr.get(j)) ;
        arr.set(j , a ) ;
    }
}

public class QuickSort_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.quickSort(arr);

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
