import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int cost[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int dp[][] = new int[n][3];
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (answer > dp[n - 1][i]) {
                answer = dp[n - 1][i];
            }
        }
        System.out.println(answer);
        
        // System.out.println(" = = = = = Cost = = = = =");
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < 3; j++) {
        //         System.out.print(cost[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        // System.out.println("\n = = = = = DP = = = = =");
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < 3; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
    }
}