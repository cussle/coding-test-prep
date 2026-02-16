import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[2][n];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && dp[0][i] <= dp[0][j]) {
                    dp[0][i] = dp[0][j] + 1;
                }
            }
        }

        dp[1][n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            dp[1][i] = 1;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i] && dp[1][i] <= dp[1][j]) {
                    dp[1][i] = dp[1][j] + 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[0][i] + dp[1][i] - 1);
        }
        
        System.out.println(answer);
    }
}
