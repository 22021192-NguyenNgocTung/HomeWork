import java.lang.reflect.Array;
import java.util.Arrays;

public class BinarySearch {
    public static int Binary_Search(int[]a , int tmp){
        int low = 0 , high = a.length - 1 ;
        int index = 0 ;
        while ( low <= high){
            index = (low + high) /2 ;
            if ( tmp < a[index]) high = index - 1 ;
            else if (tmp > a[index]) low = index + 1 ;
            else return index ;
        }
        return -1 ;
    }
    public static void main(String[] args){
        int[] a = { 1 , 3 , 5 , -1 , 0 } ;
        Arrays.sort(a,  0 , a.length) ;
        int number = 0 ;
        System.out.print(Binary_Search(a,number));
    }
}
