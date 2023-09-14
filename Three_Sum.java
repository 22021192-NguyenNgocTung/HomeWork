import edu.princeton.cs.algs4.*;
public class Three_Sum {
    public static void main(String[] args){
        In in = new In("C:\\Users\\Admin\\IdeaProjects\\algs4-data\\2Kints.txt") ;
        int[] a = in.readAllInts();
        for ( int i = 0 ; i < a.length; ++i){
            for ( int j = i + 1; j < a.length ; ++j){
                if ( a[i] > a[j]){
                    int t = a[i] ;
                    a[i] = a[j] ;
                    a[j] = t ;
                }
            }
        }
        for ( int i = 0 ; i < a.length ; ++i){
            for ( int j = i + 1 ; j < a.length ; ++j){
                int ans = - a[i] - a[j] ;
                int low = 0 , high = a.length - 1 ;
                int index = 0 ;
                while( low <= high) {
                    index = ( low + high) / 2 ;
                    if ( ans < a[index] ) high = index - 1 ;
                    else low = index + 1 ;
                }
                if (ans == a[index]){
                    System.out.println(a[i] + " " + a[j] + " " + ans);
                }
            }
        }
    }
}
