import java.util.*;
import java.io.*;

public class Main {
    static char[][] board;
    static int r, c;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static boolean[] used = new boolean[26];
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            String temp = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = temp.charAt(j);
            }
        }

        used[board[0][0] - 'A'] = true;
        dfs(0, 0, answer);
        System.out.println(answer);
    }

    private static void dfs(int cy, int cx, int cnt) {
        answer = Math.max(answer, cnt);

        for (int d = 0; d < 4; d++) {
            int ny = cy + dy[d];
            int nx = cx + dx[d];

            if (ny < 0 || ny >= r || nx < 0 || nx >= c) {
                continue;
            }

            int idx = board[ny][nx] - 'A';
            if (used[idx]) {
                continue;
            }

            used[idx] = true;
            dfs(ny, nx, cnt + 1);
            used[idx] = false;
        }
    }
}