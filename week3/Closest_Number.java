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

        /*
         * Complete the 'closestNumbers' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        public static List<Integer> closestNumbers(List<Integer> arr) {
            int[] a = new int[arr.size()] ;
            for ( int i = 0 ; i < arr.size() ; ++i){
                a[i] = arr.get(i) ;
            }
            Arrays.sort(a,0,a.length);
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

