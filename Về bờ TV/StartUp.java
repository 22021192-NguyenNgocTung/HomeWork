import java.io.*;
import java.util.*;

class Start {
    int index;
    int amount;

    public Start(int index, int amount) {
        this.index = index;
        this.amount = amount;
    }

    public boolean less(Start o){
        return amount < o.amount ;
    }
}

class MinPQ {
    public MinPQ(int size) {
        arr = new Start[size + 1];
        n = 0 ;
    }
    Start[] arr ;
    int n ;
    private void exch(int i , int j){
        Start tmp = arr[i] ;
        arr[i] = arr[j] ;
        arr[j] = tmp;
    }
    private boolean big(int i , int j){
        return arr[j].less(arr[i]) ;
    }
    private void swim(int k){
        while ( k > 1 && big(k/2 , k)){
            exch(k,k/2);
            k = k/2;
        }
    }
    public void insert(Start item){
        arr[++n] = item ;
        swim(n);
    }
    private void sink(int k){
        while (2*k <= n){
            int j = 2*k;
            if (j < n && big(j , j + 1)) j ++ ;
            if (!big(k , j)) break ;
            exch(k , j);
            k = j ;
        }
    }
    public Start delMin(){
        Start ans = arr[1];
        exch(n-- , 1);
        sink(1);
        arr[n + 1] = null ;
        return ans ;
    }
    public int size(){
        return n ;
    }
    public void clear(){
        for ( int i = 1 ; i < n ; i++){
            arr[i] = null ;
        }
        n = 0 ;
    }
    public boolean isEmpty(){
        return n == 0 ;
    }
    public int peek(){
        return arr[1].amount;
    }
}
public class StartUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        MinPQ minQue = new MinPQ(1000003);
        int u = 0;
        for (int i = 1; i < n ; i++) {
            int check = sc.nextInt();
            if (check == 1) {
                int money = sc.nextInt();
                Start tmp = new Start(i , money) ;
                minQue.insert(tmp);
            } else {
                u = sc.nextInt();
                while (minQue.size() > u - 1){
                    minQue.delMin();
                }
            }
        }
        u = sc.nextInt();
        u = sc.nextInt();
        if (minQue.size() < u) {
            System.out.println(-1);
        } else {
            long sum = 0 ;
            List<Integer> ans = new ArrayList<>();
            while (!minQue.isEmpty()){
                Start tmp = minQue.delMin();
                sum += tmp.amount;
                ans.add(tmp.index);
            }
            System.out.println(sum);
            ans.sort(Comparator.naturalOrder());
            for (Integer i : ans){
                System.out.print(i + " ");
            }
        }
    }
}