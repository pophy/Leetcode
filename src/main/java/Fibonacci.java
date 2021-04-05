/**
 * Created by Fei on 1/22/2018.
 */
public class Fibonacci {

    public static int calculateFibonacci(int n) {
        int result = 0;
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 1;int b=1;
        for (int i=3;i<=n;i++) {
            result = a + b;
            a = b;
            b = result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculateFibonacci(5));
    }

}
