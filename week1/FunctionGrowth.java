import java.util.Scanner;

public class FunctionGrowth {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in) ;
        int c = input.nextInt() ;
        int k = input.nextInt() ;
        double tmp = 1e-5;
        double x = 2.1 ;
        while ((Math.pow(x ,k) - c) > tmp){
            x = x - (Math.pow(x,k) - c) / (k * Math.pow(x, k - 1)) ;
        }
        System.out.print(x) ;
    }
}
