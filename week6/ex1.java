package main.wee6;

import edu.princeton.cs.algs4.In;

import java.io.*;
import java.util.ArrayList;

public class ex1 {
    public static void InsertionSort(int[] a ){
        for ( int i = 0 ; i < a.length ; i++){
            for ( int j = i ; j > 0 && a[j] < a[j-1] ; j--){
                swap(a , j , j - 1);
            }
        }
    }
    public static void swap(int[] a , int i , int j ){
        int t = a[i] ;
        a[i] = a[j] ;
        a[j] = t ;
    }
    public static void main(String[] args) throws IOException {

        In in = new In("C:\\Users\\Admin\\IdeaProjects\\algs4-data\\6Kints.txt"); // tạo luồng đọc từ file
        int[] a = in.readAllInts();
        long start = System.currentTimeMillis() ;
        InsertionSort(a) ;
        long end = System.currentTimeMillis() ;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Report.txt", true));
            writer.write("6Kints: " + (end - start));
            writer.newLine();
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
