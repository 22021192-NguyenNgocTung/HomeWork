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
    public int key ;
    public int value;
    public Node(int key){
        this.key = key ;
        value = 1 ;
    }
    public void setvalue(){
        value ++ ;
    }
}
class Result {

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */
    public static Node insert(Node node , int key){
        if ( node == null){
            return new Node(key);
        }
        else {
            node.setvalue();
            return node ;
        }
    }
    public static Node delete(Node node , int key){
        if ( node == null){
            Node newNode = new Node(key);
            newNode.value = -1 ;
            return newNode ;
        }
        else {
            node.value -- ;
            return node ;
        }
    }
    public static int hash(int key){
        return key%100 ;
    }
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        Node[] node = new Node[100] ;
        for ( int i = 0 ; i < brr.size() ; i++){
            int index = hash(brr.get(i));
            node[index] = insert(node[index], brr.get(i));
        }
        for (int i = 0 ; i < arr.size() ; i++){
            int index = hash(arr.get(i));
            node[index] = delete(node[index], brr.get(i) );
        }
        List <Integer> list = new ArrayList<>();
        for ( int i = 0 ; i < 100 ; i++){
            if (node[i] != null){
                if (node[i].value > 0){
                    list.add(node[i].key);
                }
            }
        }
        for ( int i = 0 ; i < list.size() - 1 ; i++){
            for ( int j = i + 1 ; j > 0 && list.get(j) < list.get(j - 1 ); j --){
                int tmp = list.get(j);
                list.set(j, list.get(j-1));
                list.set(j - 1 , tmp) ;
            }
        }
        return list ;
    }

}

public class HashTables {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.missingNumbers(arr, brr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
