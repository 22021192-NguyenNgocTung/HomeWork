import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Random generator = new Random();
        for (int tm = 0; tm < 50; tm++) {
            int n = generator.nextInt(10000) + 4;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = generator.nextInt();
            }
            long start = System.currentTimeMillis();
            for (int i = 0; i < n - 1; i++) {
                for (int j = i; j >= 0; j--) {
                    if (arr[j + 1] < arr[j]) {
                        int tmp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tmp;
                    }
                }
            }
            long end = System.currentTimeMillis();
            try {
                FileWriter fileWriter = new FileWriter("D:\\Text.txt" , true);
                BufferedWriter writer = new BufferedWriter(fileWriter);
                writer.write("n= " + n + "  Runtime:" + (end - start)) ;
                writer.newLine();
                writer.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}