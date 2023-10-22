import java.io.*;
import java.util.*;

public class StringReverse {
    public static boolean checkStringReverse(String A){
        for ( int i = 0 ; i < A.length() ; i ++){
                char a = A.charAt(i) ;
                char b = A.charAt(A.length() - 1 - i) ;
                if (!String.valueOf(a).equals(String.valueOf(b))){
                    return false ;
                }
        }
        return true ;
    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        boolean ans = checkStringReverse(A) ;
        if (ans){
            System.out.println("Yes") ;
        }
        else {
            System.out.println("No") ;
        }
    }
}



