package main.week7;

import edu.princeton.cs.algs4.Insertion;

public class PriorityQueue {
    public PriorityQueue() {
    }
    private int[] a ;
    private int k ;
    public void insert( int tmp){
        a[k++] = tmp ;
    }
    int deleteMin(){
        QuickSort_In_Place.sort(a , 0 , a.length -1);
        int[] arr = new int[k - 1] ;
        for ( int i = 0 ; i < k - 1 ; i++){
            arr[i] = a[i+1];
        }
        k--;
        int ans = a[0];
        a = arr ;
        return ans ;
    }
}
