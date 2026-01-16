import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] board;
    static enum Direction {
        UP, DOWN, LEFT, RIGHT;
    }
    static int best = -1;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());               
            }
        }

        dfs(board, 0);
        System.out.println(best);

        // System.out.println("\n\n= = = = = Debug = = = = =");
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(board[i][j] + " ");
        //     }
        //     System.out.println();
        // }
    }

    private static void dfs(int[][] cur, int depth) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                best = Math.max(best, cur[i][j]);
            }
        }

        if (depth == 5) return;

        for (Direction dir : Direction.values()) {
            int[][] next = proceed(cur, dir);
            boolean sameBoard = true;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (cur[i][j] != next[i][j]) {
                        sameBoard = false;
                        break;
                    }
                }
                if (!sameBoard) {
                    break;
                }
            }

            if (sameBoard) {
                continue;
            }

            dfs(next, depth + 1);
        }
    }

    private static int[][] proceed(int[][] cur, Direction d) {
        int[][] next = new int[n][n];

        // 깊은 복사
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < n; j++) {
                next[i][j] = cur[i][j];
            }
        }

        // UP 이라면
        if (d == Direction.UP) {
            // 당기기
            for (int i = 0; i < n; i++) {
                int write = 0;
                for (int j = 0; j < n; j++) {
                    if (next[j][i] == 0) continue;

                    int val = next[j][i];
                    next[j][i] = 0;
                    next[write][i] = val;
                    write++;
                }
            }
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n; j++) {
                    if (next[i][j] != 0 && next[i][j] == next[i + 1][j]) {
                        next[i][j] *= 2;
                        next[i + 1][j] = 0;
                    }
                }
            }
            // 당기기
            for (int i = 0; i < n; i++) {
                int write = 0;
                for (int j = 0; j < n; j++) {
                    if (next[j][i] == 0) continue;

                    int val = next[j][i];
                    next[j][i] = 0;
                    next[write][i] = val;
                    write++;
                }
            }
            return next;
        }

        // DOWN 이라면
        if (d == Direction.DOWN) {
            // 당기기
            for (int i = 0; i < n; i++) {
                int write = n - 1;
                for (int j = n - 1; j >= 0; j--) {
                    if (next[j][i] == 0) continue;

                    int val = next[j][i];
                    next[j][i] = 0;
                    next[write][i] = val;
                    write--;
                }
            }
            for (int i = n - 1; i > 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (next[i][j] != 0 && next[i][j] == next[i - 1][j]) {
                        next[i][j] *= 2;
                        next[i - 1][j] = 0;
                    }
                }
            }
            // 당기기
            for (int i = 0; i < n; i++) {
                int write = n - 1;
                for (int j = n - 1; j >= 0; j--) {
                    if (next[j][i] == 0) continue;

                    int val = next[j][i];
                    next[j][i] = 0;
                    next[write][i] = val;
                    write--;
                }
            }
            return next;
        }

        // LEFT 라면
        if (d == Direction.LEFT) {
            // 당기기
            for (int i = 0; i < n; i++) {
                int write = 0;
                for (int j = 0; j < n; j++) {
                    if (next[i][j] == 0) continue;

                    int val = next[i][j];
                    next[i][j] = 0;
                    next[i][write] = val;
                    write++;
                }
            }
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n; j++) {
                    if (next[j][i] != 0 && next[j][i] == next[j][i + 1]) {
                        next[j][i] *= 2;
                        next[j][i + 1] = 0;
                    }
                }
            }
            // 당기기
            for (int i = 0; i < n; i++) {
                int write = 0;
                for (int j = 0; j < n; j++) {
                    if (next[i][j] == 0) continue;

                    int val = next[i][j];
                    next[i][j] = 0;
                    next[i][write] = val;
                    write++;
                }
            }
            return next;
        }

        // RIGHT 라면
        if (d == Direction.RIGHT) {
            // 당기기
            for (int i = 0; i < n; i++) {
                int write = n - 1;
                for (int j = n - 1; j >= 0; j--) {
                    if (next[i][j] == 0) continue;

                    int val = next[i][j];
                    next[i][j] = 0;
                    next[i][write] = val;
                    write--;
                }
            }
            for (int i = n - 1; i > 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (next[j][i] != 0 && next[j][i] == next[j][i - 1]) {
                        next[j][i] *= 2;
                        next[j][i - 1] = 0;
                    }
                }
            }
            // 당기기
            for (int i = 0; i < n; i++) {
                int write = n - 1;
                for (int j = n - 1; j >= 0; j--) {
                    if (next[i][j] == 0) continue;

                    int val = next[i][j];
                    next[i][j] = 0;
                    next[i][write] = val;
                    write--;
                }
            }
            return next;
        }
      
        return null;
    }
}