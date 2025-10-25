import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        int[][] pressed = new int[n - 2][n - 2];

        // initial inputs
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                // System.out.print(board[i][j] + "\t");
            }
            // System.out.println("");
        }

        // pressed the inputs
        // System.out.println("");
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                pressed[i - 1][j - 1] = board[i - 1][j] + board[i][j - 1] + board[i][j] + board[i][j + 1] + board[i + 1][j];
                // System.out.print(pressed[i - 1][j - 1] + "\t");
            }
            // System.out.println("");
        }

        // calculate
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                // able to access
                boolean[][] able = new boolean[n - 2][n - 2];
                
                for (int a = 0; a < n - 2; a++) {
                    for (int b = 0; b < n - 2; b++) {
                        able[a][b] = true;
                    }
                }

                ableCord(able, n, i, j);
                
                int cur = calc(able, n, pressed, pressed[i][j]);
                answer = Math.min(answer, cur);
            }
        }

        System.out.println(answer);
    }

    private static int calc(boolean[][] able, int n, int[][] value, int cost) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n -2; i++) {
            for (int j = 0; j < n - 2; j++) {
                // skip unavailable cell
                if (!able[i][j]) {
                    continue;
                }

                int tempCost = cost + value[i][j];
                if (tempCost > min) {
                    continue;
                }

                // deep-copy able array
                boolean[][] newAble = new boolean[n - 2][n - 2];
                for (int a = 0; a < n - 2; a++) {
                    for (int b = 0; b < n - 2; b++) {
                        newAble[a][b] = able[a][b];
                    }
                }

                ableCord(newAble, n, i, j);

                for (int a = 0; a < n - 2; a++) {
                    for (int b = 0; b < n - 2; b++) {
                        if (!newAble[a][b]) {
                            continue;
                        }

                        min = Math.min(min, tempCost + value[a][b]);
                    }
                }
            }
        }

        return min;
    }

    private static void ableCord(boolean[][] able, int n, int initC, int initR) {
        for (int a = 0; a < n - 2; a++) {
            for (int b = 0; b < n - 2; b++) {
                // vertical
                if (b == initR && a >= initC - 2 && a <= initC + 2) {
                    able[a][b] = false;
                }

                // horizontal
                if (a == initC && b >= initR - 2 && b <= initR + 2) {
                    able[a][b] = false;
                }

                // diagonal
                if ((a >= initC - 1 && a <= initC + 1) && (b >= initR - 1 && b <= initR + 1)) {
                    able[a][b] = false;
                }
            }
        }
    }
}