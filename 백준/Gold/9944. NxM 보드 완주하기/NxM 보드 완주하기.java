import java.io.*;
import java.util.*;

public class Main {
    static final int dr[] = {0, 0, -1, 1};
    static final int dc[] = {-1, 1, 0, 0};
    static int best;  // min num of moves
    static int total;  // total num of empty cells

    static class MoveResult {
        int r;
        int c;
        List<int[]> changed;  // newly visited cells (for rollback)

        MoveResult(int r, int c, List<int[]> changed) {
            this.r = r;
            this.c = c;
            this.changed = changed;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        String input;
        int round = 0;
        while ((input = br.readLine()) != null) {  // multiple test cases till EOF
            st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            boolean board[][] = new boolean[n][m];
            boolean visited[][] = new boolean[n][m];
            best = Integer.MAX_VALUE;
            total = 0;

            for (int i = 0; i < n; i++) {
                String cells = br.readLine();
                for (int j = 0; j < m; j++) {
                    if (board[i][j] = (cells.charAt(j) == '.')) {
                        total++;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j]) {
                        visited[i][j] = true;
                        dfs(board, visited, n, m, i, j, 0, 1);
                        visited[i][j] = false;
                    }
                }
            }

            int answer = (best == Integer.MAX_VALUE) ? -1 : best;
            sb.append("Case ").append(++round).append(": ").append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }

    // backtracking dfs
    private static void dfs(boolean[][] board, boolean[][] visited, int n, int m, int r, int c, int move, int visitedCnt) {
        // pruning
        if (move >= best) {
            return;
        }

        if (visitedCnt == total) {
            best = Math.min(best, move);
            return;
        }

        for (int d = 0; d < 4; d++) {
            MoveResult mr = moveStraight(board, visited, n, m, r, c, d);
            if (mr.changed.size() == 0) {
                continue;
            }

            dfs(board, visited, n, m, mr.r, mr.c, move + 1, visitedCnt + mr.changed.size());
            rollback(visited, mr.changed);
        }
    }

    // check if it can move to d
    private static boolean canMove(boolean[][] board, boolean[][] visited, int n, int m, int r, int c, int d) {
        int nr = r + dr[d];
        int nc = c + dc[d];
        if (nr < 0 || nr >= n || nc < 0 || nc >= m || !board[nr][nc] || visited[nr][nc]) {
            return false;
        }

        return true;
    }

    // perform move
    private static MoveResult moveStraight(boolean[][] board, boolean[][] visited, int n, int m, int r, int c, int d) {
        int cr = r;
        int cc = c;
        List<int[]> changed = new ArrayList<>();

        while (canMove(board, visited, n, m, cr, cc, d)) {
            cr += dr[d];
            cc += dc[d];

            visited[cr][cc] = true;
            changed.add(new int[]{cr, cc});
        }

        return new MoveResult(cr, cc, changed);
    }

    // undo the visited marks
    private static void rollback(boolean[][] visited, List<int[]> changed) {
        for (int[] cell : changed) {
            visited[cell[0]][cell[1]] = false;
        }
    }
}
