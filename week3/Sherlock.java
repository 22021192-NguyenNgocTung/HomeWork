import java.util.Scanner;

public class Sherlock {
    public static boolean check(int[] a ){
        int sum = 0 ;
        for (int j : a) {
            sum += j;
        }
        int left_sum = 0 ;
        for ( int i = 0 ; i < a.length ; ++i){
            if ( i >= 1 ){
                left_sum += a[i-1] ;
            }
            System.out.println(left_sum) ;
            if (sum - a[i] - left_sum == left_sum){
                return true ;
            }
        }
        return false ;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in) ;
        int n = input.nextInt();
        boolean[] ans = new boolean[n] ;
        for ( int i = 0 ; i < n ; ++i){
            int size = input.nextInt() ;
            int[] a = new int[size] ;
            for ( int j = 0 ; j < size ; ++j){
                a[j] = input.nextInt() ;
            }
            ans[i] = check(a) ;
        }
        for ( int i = 0 ; i < n ; ++i){
            if (ans[i]) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
