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
        int dem = 0 ;
        for ( int i = 0 ; i < a.length - 2 ; ++i){
            int j = i + 1 ;
            int sum = -100 ;
            for ( int k = a.length - 1; k > j ; --k ){
                while ( j < k ){
                    sum = a[i] + a[j] + a[k] ;
                    if ( sum == 0){
                        dem ++ ;
                        j++ ;
                    }
                    else if ( sum < 0 ){
                        j ++ ;
                    }
                    else break ;
                }
            }
        }
    }
}
