import java.io.*;
import java.util.*;

public class query {
    public static void buildTree(int[] a, int[] tree, int index, int l, int r) {
        if (l == r) {
            tree[index] = a[l];

            return;
        }
        int mid = (r + l) / 2;
        buildTree(a, tree, index * 2, l, mid);
        buildTree(a, tree, index * 2 + 1, mid + 1, r);
        tree[index] = Math.max(tree[index * 2], tree[index * 2 + 1]);
    }

    public static int getVal(int[] tree, int index, int l, int r, int u, int v) {
        if (u > r || v < l) {
            return -1;
        }
        if (u <= l && r <= v  ) {
            return tree[index];
        }
        int m = (l + r) / 2;
        return Math.max(getVal(tree, index * 2, l, m, u, v), getVal(tree, index * 2 + 1, m + 1, r, u, v));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int[] tree = new int[n * 4 + 4];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        buildTree(a, tree, 1, 1, n);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            System.out.println(getVal(tree, 1, 1, n, u, v));
        }
    }
}