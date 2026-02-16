import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        while (t --> 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][][] dp = new int[2][2][n];
            dp[1][0][0] = stickers[0][0];
            dp[1][1][0] = stickers[1][0];
            for (int i = 1; i < n; i++) {
                dp[0][0][i] = Math.max(Math.max(dp[0][0][i - 1], dp[1][0][i - 1]), Math.max(dp[0][1][i - 1], dp[1][1][i - 1]));
                dp[0][1][i] = Math.max(Math.max(dp[0][0][i - 1], dp[1][0][i - 1]), Math.max(dp[0][1][i - 1], dp[1][1][i - 1]));
                dp[1][0][i] = stickers[0][i] + Math.max(dp[0][0][i - 1], Math.max(dp[0][1][i - 1], dp[1][1][i - 1]));
                dp[1][1][i] = stickers[1][i] + Math.max(dp[0][1][i - 1], Math.max(dp[0][0][i - 1], dp[1][0][i - 1]));
            }

            sb.append(Math.max(Math.max(dp[0][0][n - 1], dp[0][1][n - 1]), Math.max(dp[1][0][n - 1], dp[1][1][n - 1]))).append("\n");

            // debug
            // for (int i = 0; i < 2; i++) {
            //     for (int j = 0; j < n; j++) {
            //         System.out.print(stickers[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            // for (int i = 0; i < 2; i++) {
            //     for (int j = 0; j < n; j++) {
            //         System.out.print(dp[0][i][j] + "/" + dp[1][i][j] + " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println();
        }

        System.out.println(sb.toString());
    }
}
