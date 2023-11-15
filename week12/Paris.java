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
class Node{
    int key ;
    Node next ;
    public Node(int key){
        this.key = key ;
    }
}
class Result {

    /*
     * Complete the 'pairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */
    public static Node insert(Node node , int key){
        Node newNode = new Node(key);
        if (node != null){
            newNode.next = node ;
        }
        return newNode ;
    }
    public static int count(Node node , int k){
        List <Integer> list = new ArrayList<>() ;
        while (node != null){
            list.add(node.key);
            node = node.next ;
        }
        int ans = 0 ;
        for ( int i = 0 ; i < list.size() ; i++){
            for ( int j = i + 1 ; j < list.size() ; j++){
                if (Math.abs(list.get(i) - list.get(j)) == k){
                    ans ++ ;
                }
            }
        }
        return ans ;
    }
    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        Node[] nodes = new Node[k] ;
        for ( int i = 0 ; i < arr.size() ; i++){
            int index = arr.get(i) % k ;
            nodes[index] = insert(nodes[index], arr.get(i));
        }
        int ans = 0 ;
        for ( int i = 0 ; i < nodes.length ; i++){
            ans += count(nodes[i] , k) ;
        }
        return ans ;
    }

}

public class Paris {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
