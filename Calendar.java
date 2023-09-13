import java.util.Scanner;

public class Calendar {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in) ;
        int m = input.nextInt() ;
        int y = input.nextInt() ;
        System.out.println("Su Mo Tu We Th Fr Sa ");
        switch (check(1,m,y)){
            case 0 : System.out.print  ("1  ");break ;
            case 1 : System.out.print  ("   1  ");break ;
            case 2 : System.out.print  ("      1  ");break ;
            case 3 : System.out.print  ("         1  ");break ;
            case 4 : System.out.print  ("            1  ");break ;
            case 5 : System.out.print  ("               1  ");break ;
            case 6 : System.out.println("                  1  ");break ;
        }
        for (int i = 2; i <= 9; ++i) {
            if ( check(i,m,y) == 6){
                System.out.println(i + "  ");
            }
            else {
                System.out.print(i + "  ") ;
            }
        }
        if ( m == 2){
            if ( y % 4 == 0) {
                for ( int i = 10 ; i <= 29 ; ++i){
                    if ( check(i,m,y) == 6){
                        System.out.println(i + " ");
                    }
                    else {
                        System.out.print(i + " ") ;
                    }
                }
            }
            else {
                for ( int i = 10 ; i <= 28 ; ++i){
                    if ( check(i,m,y) == 6){
                        System.out.println(i + " ");
                    }
                    else {
                        System.out.print(i + " ") ;
                    }
                }
            }
        }
        else if ( m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12){
            for ( int i = 10 ; i <= 31 ; ++i){
                if ( check(i,m,y) == 6){
                    System.out.println(i + " ");
                }
                else {
                    System.out.print(i + " ") ;
                }
            }
        }
        else {
            for ( int i = 10 ; i <= 30 ; ++i){
                if ( check(i,m,y) == 6){
                    System.out.println(i + " ");
                }
                else {
                    System.out.print(i + " ") ;
                }
            }
        }
    }
    private static int check(int d , int m , int y){
        int y0 = y - (14 - m) / 12 ;
        int x = y0 + y0/4 - y0/100 + y0/400 ;
        int m0 = m + 12 * ((14 - m) / 12) - 2 ;
        int d0 = (d + x + (31*m0)/ 12) ;
        return d0%7 ;
    }
}

