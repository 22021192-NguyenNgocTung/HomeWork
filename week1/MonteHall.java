import java.util.Random;
import java.util.Scanner;

public class MonteHall {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in) ;
        int n = input.nextInt() ;
        Random generator = new Random() ;
        int win1 = 0 , win2 = 0 ;
        for ( int i = 1 ; i <= n ; ++i) {
            int luck_number = generator.nextInt(3) + 1;
            int chouse = generator.nextInt(3) + 1;
            int open = chouse;
            while (open == chouse) {
                open = generator.nextInt(3) + 1;
            }
            if (chouse == luck_number){
                win1 ++ ;
            }
            else if (open != luck_number){
                    win2++ ;
                }
        }
        System.out.println(100.0* win1 /n + "%" ) ;
        System.out.println(100.0* win2 /n + "%" ) ;
    }
}
