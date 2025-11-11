import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[n][m][3];  // 0: right_bottom, 1: bottom, 2:left_bottom
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                dp[0][i][j] = board[0][i];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = 100_001;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // case 0
                if (j + 1 < m) {
                    dp[i][j][0] = Math.min(dp[i][j][0], Math.min(dp[i - 1][j + 1][1] + board[i][j], dp[i - 1][j + 1][2] + board[i][j]));
                }
                
                // case 1
                dp[i][j][1] = Math.min(dp[i][j][1], Math.min(dp[i - 1][j][0] + board[i][j], dp[i - 1][j][2] + board[i][j]));

                // case 2
                if (j - 1 >= 0) {
                    dp[i][j][2] = Math.min(dp[i][j][2], Math.min(dp[i - 1][j - 1][0] + board[i][j], dp[i - 1][j - 1][1] + board[i][j]));
                }
            }
        }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(dp[i][j][0] + " ");
        //     }
        //     System.out.println();
        // }

        // System.out.println();
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(dp[i][j][1] + " ");
        //     }
        //     System.out.println();
        // }

        // System.out.println();
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(dp[i][j][2] + " ");
        //     }
        //     System.out.println();
        // }

        // System.out.println();
        // System.out.println();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                min = Math.min(min, dp[n - 1][i][j]);
            }
        }
        System.out.println(min);
    }
}