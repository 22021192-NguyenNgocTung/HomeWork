
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BFS {

    static int[] findShortestReach(ArrayList<ArrayList<Integer>> graph, int start) {
        int[] costs = new int[graph.size()];
        int UNIT_COST = 6;
        boolean[] visited = new boolean[graph.size()];
        for ( int i = 0 ; i < graph.size() ; i++){
            costs[i] = -1;
            visited[i] = false ;
        }
        visited[start] = true ;
        costs[start] = 0 ;
        Queue <Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true ;
        while (!queue.isEmpty()){
            int x = queue.poll();
            for ( int i = 0 ; i < graph.get(x).size() ;i++){
                if (!visited[graph.get(x).get(i)]){
                    queue.add(graph.get(x).get(i));
                    costs[graph.get(x).get(i)] = costs[x] + UNIT_COST ;
                    visited[graph.get(x).get(i)] = true ;
                }
            }
        }
        return costs;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        for (int q = 0; q < Q; ++q) {
            int N, M, start;
            N = scanner.nextInt();
            M = scanner.nextInt();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i <= N; ++i) {
                graph.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < M; ++i) {
                int n1, n2;
                n1 = scanner.nextInt();
                n2 = scanner.nextInt();
                graph.get(n1).add(n2);
                graph.get(n2).add(n1);
            }
            start = scanner.nextInt();
            /*
            for (int i = 0; i < N; ++i) {
                Collections.sort(graph.get(i));
            }
            for (int i = 1; i <= N; ++i) {
                System.out.println("Node: " + i);
                System.out.println(graph.get(i).toString());
            }
            System.out.println("Start: " + start);
            */
            int[] costs = findShortestReach(graph, start);
            for (int i = 1; i < costs.length; ++i) {
                if (i == start) continue;
                System.out.print(costs[i] + " ");
            }
            System.out.println();
        }
    }
}
