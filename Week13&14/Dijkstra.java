import java.io.*;
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

class Node {
    int id;
    HashMap<Node, Integer> Neighbor;
    int distance;

    public Node(int id) {
        this.id = id;
        this.Neighbor = new HashMap<Node, Integer>();
        this.distance = -1;
    }
}

class Result {

    /*
     * Complete the 'shortestReach' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER s
     */

    public static int minIndex(ArrayList<Node> Q) {
        int output = -1;
        int minDistance = 65536000;
        for (int i = 0; i < Q.size(); i++) {
            if (Q.get(i).distance < minDistance) {
                output = i;
                minDistance = Q.get(i).distance;
            }

        }
        return output;
    }

    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        // Write your code here
        Node[] A = new Node[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            A[i] = new Node(i);
            visited[i] = false;
        }
        for (int k = 0; k < edges.size(); k++) {
            int i = edges.get(k).get(0) - 1;
            int j = edges.get(k).get(1) - 1;
            int weight = edges.get(k).get(2);
            Node N1 = A[i];
            Node N2 = A[j];
            if (!N1.Neighbor.keySet().contains(N2) || N1.Neighbor.get(N2) > weight) {
                N1.Neighbor.put(N2, weight);
            }
            if (!N2.Neighbor.keySet().contains(N1) || N2.Neighbor.get(N1) > weight) {
                N2.Neighbor.put(N1, weight);
            }
        }
        ArrayList<Node> Q = new ArrayList<Node>();
        Node startNode = A[s - 1];
        startNode.distance = 0;
        List<Integer> list = new ArrayList<>();
        visited[s - 1] = true;
        Q.add(startNode);
        Q.add(startNode);
        while (Q.size() > 0) {
            int headIndex = minIndex(Q);
            Node headNode = Q.get(headIndex);
            for (Node tmp : headNode.Neighbor.keySet()) {
                if (!visited[tmp.id]) {
                    Q.add(tmp);
                    visited[tmp.id] = true;
                }
                //treat its distance
                if (tmp.distance == -1 || tmp.distance > headNode.distance + headNode.Neighbor.get(tmp)) {
                    tmp.distance = headNode.distance + headNode.Neighbor.get(tmp);
                }

            }
            Q.remove(headIndex);
        }
        for (int i = 0; i < n; i++) {
            if (i != s - 1) list.add(A[i].distance);
        }
        return list ;
    }
}

public class Dijkstra {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
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

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result.shortestReach(n, edges, s);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
