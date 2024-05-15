import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] dp;

    public static int fibo(int n) {
        if (n < 2) {
            return n;
        } else if (dp[n] == 0) {
            dp[n] = ((fibo(n-1) + fibo(n-2)) % 1000000007);
        }

        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        dp = new int[n + 1];

        System.out.println(fibo(n));
    }
}
