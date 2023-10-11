import java.util.Scanner;

public class Jamanujan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        for ( int i = 1 ; i * i * i < N / 2 ; ++i) {
            for (int j = 1; j * j * j <= N - i * i * i; ++j) {
                if (i * i * i + j * j * j == N) {
                    System.out.println(i + " " + j);
                }
            }
        }

    }
}
