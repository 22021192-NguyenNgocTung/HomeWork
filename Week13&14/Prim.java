import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
class Edge implements Comparable<Edge>{
    public int v ;
    public int weight;

    public Edge(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }
    @Override
    public int compareTo(Edge o) {
        return Integer.compare(weight, o.weight);
    }
}
class Result {

    /*
     * Complete the 'prims' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER start
     */

    public static int prims(int n, List<List<Integer>> edges, int start) {
        // Write your code here
        int sum = 0 ;
        boolean[] visited = new boolean[n+1] ;
        List<List<Edge>> list = new ArrayList<>();
        for ( int i = 0 ; i <= n ; i++){
            list.add(new ArrayList<Edge>()) ;
            visited[i] = false ;
        }
        for (List<Integer> i : edges){
            list.get(i.get(0)).add(new Edge(i.get(1) , i.get(2))) ;
            list.get(i.get(1)).add(new Edge(i.get(0) , i.get(2))) ;
        }
        visited[start] = true ;
        Queue<Edge> queue = new PriorityQueue<>() ;
        queue.addAll(list.get(start));
        int num = 0 ;
        while (num + 1 < n){
            Edge edge = queue.poll();
            if (!visited[edge.v]){
                visited[edge.v] = true ;
                queue.addAll(list.get(edge.v));
                sum += edge.weight ;
                num ++ ;
            }
        }
        return sum ;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                edges.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int start = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.prims(n, edges, start);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
