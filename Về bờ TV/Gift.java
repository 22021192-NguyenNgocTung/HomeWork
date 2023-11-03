
import java.util.*;


public class Gift {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> minPQ = new PriorityQueue<>() ;
        int n = sc.nextInt();
        int size = sc.nextInt();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if (minPQ.size() < size) {
                minPQ.add(tmp);
                sum += tmp;
            } else {
                if (!minPQ.isEmpty() && minPQ.peek() < tmp) {
                    int min = minPQ.poll();
                    minPQ.add(tmp);
                    sum = sum - min + tmp;
                }
            }
            System.out.print(sum + " ");
        }
    }
}