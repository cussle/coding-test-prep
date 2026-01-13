import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[][] board = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = st.nextToken().equals("0");
            }
        }

        // 0: horizental, 1: vertical, 2: diagonal
        int[][][] dp = new int[3][n][n];
        dp[0][0][1] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[0][i][j] != 0) {
                    if (j + 1 < n && board[i][j + 1]) {
                        dp[0][i][j + 1] += dp[0][i][j];
                    }

                    if (j + 1 < n && i + 1 < n && board[i][j + 1] && board[i + 1][j] && board[i + 1][j + 1]) {
                        dp[2][i + 1][j + 1] += dp[0][i][j];
                    }
                }

                if (dp[1][i][j] != 0) {
                    if (i + 1 < n && board[i + 1][j]) {
                        dp[1][i + 1][j] += dp[1][i][j];
                    }

                    if (i + 1 < n && j + 1 < n && board[i][j + 1] && board[i + 1][j] && board[i + 1][j + 1]) {
                        dp[2][i + 1][j + 1] += dp[1][i][j];
                    }
                }

                if (dp[2][i][j] != 0) {
                    if (j + 1 < n && board[i][j + 1]) {
                        dp[0][i][j + 1] += dp[2][i][j];
                    }

                    if (i + 1 < n && board[i + 1][j]) {
                        dp[1][i + 1][j] += dp[2][i][j];
                    }

                    if (i + 1 < n && j + 1 < n && board[i][j + 1] && board[i + 1][j] && board[i + 1][j + 1]) {
                        dp[2][i + 1][j + 1] += dp[2][i][j];
                    }
                }
            }
        }

        System.out.println(dp[0][n - 1][n - 1] + dp[1][n - 1][n - 1] + dp[2][n - 1][n - 1]);
    }
}