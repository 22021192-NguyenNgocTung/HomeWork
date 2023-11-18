import java.util.Scanner;

public class Query2 {
    public static void buildTree(int[] a, int[] tree, int index, int l, int r) {
        if (l == r) {
            tree[index] = a[l];
            return;
        }
        int mid = (l + r) / 2;
        buildTree(a, tree, index * 2, l, mid);
        buildTree(a, tree, index * 2 + 1, mid + 1, r);
        tree[index] = Math.min(tree[index * 2], tree[index * 2 + 1]);
    }

    public static int getVal(int[] tree, int index, int l, int r, int u, int v) {
        if (u > r || v < l) {
            return (int)Math.pow(2,31) - 1;
        }
        if (u <= l && v >= r) {
            return tree[index];
        }
        int m = (l + r) / 2;
        return Math.min(getVal(tree, index * 2, l, m, u, v), getVal(tree, index * 2 + 1, m + 1, r, u, v));
    }

    public static void update(int[] tree, int index, int l, int r, int pos, int count) {
        if (pos < l || pos > r) {
            return;
        }
        if (l == r) {
            tree[index] = count;
            return;
        }
        int mid = (l + r) / 2;
        if (pos <= mid) {
            update(tree, index * 2, l, mid, pos, count);
        } else {
            update(tree, index * 2 + 1, mid + 1, r, pos, count);
        }
        tree[index] = Math.min(tree[index * 2], tree[index * 2 + 1]);
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
        for (int i = 1; i <= m; i++) {
            int check = sc.nextInt();
            int u = sc.nextInt();
            int v = sc.nextInt();
            if (check == 1) {
                System.out.println(getVal(tree, 1, 1, n, u, v));
            } else {
                update(tree, 1, 1, n, u, v);

            }
        }

    }
}