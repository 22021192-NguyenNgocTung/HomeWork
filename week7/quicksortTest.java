

import edu.princeton.cs.algs4.In;

import java.io.BufferedWriter;
import java.io.FileWriter;

class quicksort {
    private static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (a[++i] < a[lo]) {
                if (i == hi) break;
            }
            while (a[--j] > a[lo]) {
                if (j == lo) break;
            }
            if (i >= j) break;
            else {
                exch(a, i, j);
            }
        }
        exch(a, lo, j);
        return j;
    }

    private static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void sort(int[] a) {
        sort(a,0,a.length -1 );
    }
}

public class quicksortTest {
    public static void main(String[] args) {
        In in = new In("C:\\Users\\Admin\\IdeaProjects\\algs4-data\\4Kints.txt"); // tạo luồng đọc từ file
        int[] a = in.readAllInts();
        long start = System.currentTimeMillis();
        quicksort.sort(a);
        long end = System.currentTimeMillis();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\GitHub\\HomeWork\\week7\\Report.txt", true));
            writer.write("4Kints: " + (end - start));
            writer.newLine();
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}