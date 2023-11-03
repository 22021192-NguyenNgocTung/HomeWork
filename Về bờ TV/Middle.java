

import java.util.*;

public class Middle {
    public static Queue<Integer> minQueue = new PriorityQueue<>();
    public static Queue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

    public static void insert(int a) {
        if (maxQueue.peek() == null) {
            maxQueue.offer(a);
        } else if (a < maxQueue.peek()) {
            maxQueue.offer(a);
        } else {
            minQueue.offer(a);
        }
        refresh();
    }

    public static void refresh() {
        while (maxQueue.size() < minQueue.size()) {
            maxQueue.offer(minQueue.poll());
        }
        while (minQueue.size() + 1 < maxQueue.size()) {
            minQueue.offer(maxQueue.poll());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            insert(tmp);
        }
        for (int i = 0; i < m; i++) {
            int tmp = sc.nextInt();
            if (tmp == 1) {
                int u = sc.nextInt();
                insert(u);
            } else if (tmp == 2) {
                if (!maxQueue.isEmpty()) {
                    maxQueue.poll();
                    refresh();
                }
            } else {
                if (maxQueue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(maxQueue.peek());
                }
            }
        }
    }
}
