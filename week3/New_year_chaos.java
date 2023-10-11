import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int sum = 0 ;
        boolean check = true ;
        for ( int i = 0 ; i < q.size() ; ++i){
            int dem = 0 ;
            for ( int j = i + 1 ; j < q.size() ; ++j){
                if ( q.get(i) > q.get(j) ) dem ++ ;
            }
            if ( dem > 2) {
                check = false ;
                break;
            }
            sum += dem ;
        }
        if ( check ){
            System.out.println(sum) ;
        }
        else {
            System.out.println("Too chaotic");
        }
    }

}

public class New_year_chaos {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}