package main.week7;

import java.util.Arrays;
import java.util.List;

class Result {

    public static int pairs(int k, List<Integer> arr) {
        int[] a = new int[arr.size()];
        for (int i = 0; i < arr.size(); ++i) {
            a[i] = arr.get(i);
        }
        int dem = 0;
        Arrays.sort(a, 0, a.length);
        int low = 0, high = 1;
        while (high < a.length) {
            if (a[high] - a[low] < k) high++;
            else {
                if (a[high] - a[low] == k) {
                    dem++;
                }
                low++;
            }
        }
        return dem;
        // Write your code here

    }

}

public class Pairs {

}
