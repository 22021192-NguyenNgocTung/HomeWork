package main.week7;

import java.util.Scanner;

public class QuickSort_In_Place {
    public static int partition(int[] arr , int lo , int hi){
        int pivot = arr[hi];
        int j = lo;
        for (int i = lo; i < hi; i++) {
            if (arr[i] < pivot) {
                exch(arr , i , j);
                j++;
            }
        }

        exch(arr , hi , j);

        for (int k : arr) {
            System.out.print(k + " ");
        }
        System.out.println();

        return j;
    }
    public static void sort(int[] arr , int lo , int hi){
        if ( lo >= hi) return ;
        int mid = partition(arr , lo , hi) ;
        sort(arr, lo , mid - 1);
        sort(arr, mid + 1 , hi);
    }
    public static void exch(int[] a , int i , int j){
        int tmp = a[i] ;
        a[i] = a[j] ;
        a[j] = tmp ;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt();
        int[] arr = new int[n] ;
        for ( int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt() ;
        }
        sort(arr , 0 , arr.length - 1);
    }
}
