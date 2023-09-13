import edu.princeton.cs.algs4.*;
public class Two_Sum {
    public static void main(String[] args){
        In in = new In("C:\\Users\\Admin\\IdeaProjects\\algs4-data\\1Kints.txt") ;
        int[] a = in.readAllInts();
        for ( int i = 0 ; i < a.length - 1 ; ++i){
            for ( int j = i + 1 ; j < a.length ; ++j){
                if ( a[i] + a[j] == 0){
                    System.out.println(a[i] + " " + a[j]);
                }
            }
        }
    }
}
