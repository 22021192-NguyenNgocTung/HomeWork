import java.util.Scanner;

public class UnionFind {
    public static int[] root = new int[100] ;
    public static int get_root( int x) {
        if (root[x] < 0){
            return x ;
        }
        else return get_root(root[x]) ;
    }
    public static void main(String[] args){
        int n , m ;
        Scanner input = new Scanner(System.in) ;
        n = input.nextInt() ;
        for ( int i = 0 ; i < n ; ++i) {
            root[i] = -1;
        }
        int dem = n ;
        int check = 0 ;
        while (input.hasNextInt()){
            int x ;
            int y ;
            x = input.nextInt() ;
            y = input.nextInt() ;
            int root_x = get_root(x);
            int root_y = get_root(y);
            if ( root_x != root_y){
                if (root[x] < root[y]) {
                    root[x] += root[y] ;
                    root[y] = root_x ;
                }
                else {
                    root[y] += root[x] ;
                    root[x] = root_y;
                }
                dem -- ;
            }
            check ++;
            if ( dem == 1){
                System.out.print(check) ;
                break ;
            }
        }
        if ( dem != 1){
            System.out.print("FAILED") ;
        }
    }
}


