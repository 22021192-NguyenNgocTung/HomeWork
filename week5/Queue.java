import java.util.*;


class ArrayStack {
    private int[] a;
    private int n;

    ArrayStack() {
        a = new int[8];
        n = 0;
    }
    public int sizeof() {
        return n;
    }

    public void resize(int size) {
        int[] copy = new int[size * 2];
        for (int i = 0; i < n; i++) {
            copy[i] = a[i];
        }
        a = copy;
    }

    public void push(int s) {
        if (n == a.length) {
            resize(a.length * 2);
        }
        a[n] = s;
        n++;
    }

    public int pop() {
        int s = a[n - 1];
        a[n - 1] = 0;
        n--;
        if (n == a.length / 4) {
            resize(a.length / 2);
        }
        return s;
    }
    public boolean isEmpty() {
        return n == 0;
    }
    public int peek() {
        return a[n-1];
    }
    public void println(){
        for ( int i = 0 ; i < n ; i++){
            System.out.println(a[i]) ;
        }
    }
}
public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        ArrayStack stack1 = new ArrayStack() ;
        ArrayStack stack2 = new ArrayStack() ;
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        for ( int i = 0 ; i < n ; ++i){
            int a = sc.nextInt() ;
            if ( a == 1) {
                int b = sc.nextInt() ;
                stack1.push(b);
            }
            else {
                if (stack2.isEmpty()){
                    while(!stack1.isEmpty()){
                        stack2.push(stack1.pop());
                    }
                }
                if ( a == 2){
                    stack2.pop() ;
                }
                else {
                    System.out.println(stack2.peek()) ;
                }
            }
        }
    }
}
