import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] board = new char[n * 5][7];
        for (int i = 0; i < n * 5; i++) {
            String temp = br.readLine();
            for (int j = 0; j < 7; j++) {
                board[i][j] = temp.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;
        int idx1 = -1, idx2 = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                int cnt = 0;
                for (int r = 0; r < 5; r++) {
                    for (int c = 0; c < 7; c++) {
                        if (board[5 * i + r][c] != board[5 * j + r][c]) {
                            cnt++;
                        }
                    }
                }

                if (cnt < min) {
                    min = cnt;
                    idx1 = i;
                    idx2 = j;
                }
            }
        }

        System.out.println((Math.min(idx1, idx2) + 1) + " " + (Math.max(idx1, idx2) + 1));
    }
}