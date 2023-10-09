package main.wee6;

import edu.princeton.cs.algs4.In;

import java.io.*;
import java.util.ArrayList;

public class ex2 {
    public static void SelectionSort(int[] a ){
        for ( int i = 0 ; i < a.length ; i++){
            int index = i ;
            for ( int j = i + 1 ; j < a.length ; j++){
                if ( a[j] < a[index]) {
                    index = j ;
                }
            }
            swap(a, i , index);
        }
    }
    public static void swap(int[] a , int i , int j ){
        int t = a[i] ;
        a[i] = a[j] ;
        a[j] = t ;
    }
    public static void main(String[] args) throws IOException {

        In in = new In("C:\\Users\\Admin\\IdeaProjects\\algs4-data\\4Kints.txt"); // tạo luồng đọc từ file
        int[] a = in.readAllInts();
        long start = System.currentTimeMillis() ;
        SelectionSort(a); ;
        long end = System.currentTimeMillis() ;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Report.txt", true));
            writer.write("4Kints: " + (end - start));
            writer.newLine();
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
