import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n][10];  // 0-base

        // init
        for (int i = 1; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < 10; j++) {
                if (j != 0) {
                    dp[i + 1][j - 1] += dp[i][j];
                    dp[i + 1][j - 1] %= 1_000_000_000;
                }

                if (j != 9) {
                    dp[i + 1][j + 1] += dp[i][j];
                    dp[i + 1][j + 1] %= 1_000_000_000;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[n - 1][i];
            answer %= 1_000_000_000;
        }

        System.out.println(answer);
    }
}