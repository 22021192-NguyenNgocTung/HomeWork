\import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    static int[][] grid ;
    static boolean[][] visited;

    static int N ;
    static int M ;
    /*
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */
    public static int connectedCell(List<List<Integer>> matrix) {
        N = matrix.size();
        M = matrix.get(0).size();
        grid = new int[N][M];
        visited = new boolean[N][M];

        for ( int i = 0 ; i < N ; i++){
            for ( int j = 0 ; j < M ; j++){
                grid[i][j] = matrix.get(i).get(j);
                visited[i][j] = false ;
            }
        }
        int max = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (grid[i][j] == 0 || visited[i][j]) continue;
                int cnt = countConnected(i, j);
                if (max < cnt) max = cnt;
            }
        }
        return max ;
    }
    public static int countConnected(int row , int col){
        int cnt = 1 ;
        visited[row][col] = true ;
        for ( int i = -1 ; i <= 1 ; i++){
            for ( int j = -1 ; j <= 1 ; j++){
                if (row + i < N && row + i >= 0 && col + j >= 0 && col + j < M ){
                    if (grid[row + i][col + j] == 0 || visited[row + i][col + j]) continue;
                    else {
                        cnt += countConnected(row + i , col + j) ;
                    }
                }
            }
        }
        return cnt;
    }

}

public class ConnectedCell {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
