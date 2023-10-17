package main.week7;

import edu.princeton.cs.algs4.In;

import java.io.BufferedWriter;
import java.io.FileWriter;

class mergesort {
    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) aux[k] = a[j++];
            else if (j > hi) aux[k] = a[i++];
            else if (a[i] < a[j]) aux[k] = a[i++];
            else {
                aux[k] = a[j++];
            }
        }
    }

    private static void sort(int[] a, int[] aux, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        if (a[mid] < a[mid+1]) return ;
        merge(a, aux, lo, mid, hi);
    }
    public static void sort(int[] a){
        int[] aux = new int[a.length];
        sort(a , aux , 0 , a.length-1) ;
    }
}
public class mergesortTest {
    public static void main(String[] args){
        In in = new In("C:\\Users\\Admin\\IdeaProjects\\algs4-data\\6Kints.txt"); // tạo luồng đọc từ file
        int[] a = in.readAllInts();
        long start = System.currentTimeMillis() ;
        mergesort.sort(a);
        long end = System.currentTimeMillis() ;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\GitHub\\HomeWork\\week7\\Report.txt", true));
            writer.write("6Kints: " + (end - start));
            writer.newLine();
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

