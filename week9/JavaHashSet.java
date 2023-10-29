import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JavaHashSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() ;
        sc.nextLine();
        Set<String> ans = new HashSet<>();
        String tmp ;
        for ( int i = 0 ; i < n ; i++){
            tmp = sc.nextLine();
            ans.add(tmp);
            System.out.println(ans.size());
        }
    }
}
