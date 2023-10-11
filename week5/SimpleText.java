import java.io.*;
import java.util.*;

public class Solution {

    public static String S = "";
    public static Stack<String> stack_undo = new Stack<>();
    public static String append(String s) {
        stack_undo.push(S);
        return S.concat(s);
    }

    public static String delete(int k) {
        stack_undo.push(S);
        if ( k == S.length()) {
            return "" ;
        }
        return S.substring(0,S.length() - k);
    }

    public static void print(int index) {
        System.out.println(S.charAt(index - 1));
    }
    public static void undo() {
        S = stack_undo.pop();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (a == 1) {
                String ss = sc.next();
                S = append(ss);
            }
            if (a == 2) {
                int k = sc.nextInt() ;
                S = delete(k) ;
            }
            if ( a ==3 ){
                int k = sc.nextInt() ;
                print(k);
            }
            if ( a == 4) {
                undo();
            }
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}
