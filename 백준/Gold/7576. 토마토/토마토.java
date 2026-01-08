import java.io.*;
import java.util.*;

public class Main {
    final static int dy[] = {1, -1, 0, 0};
    final static int dx[] = {0, 0, 1, -1};

    private static class Coor {
        int y, x, days;
        Coor(int y, int x, int days) {
            this.y = y;
            this.x = x;
            this.days = days;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int board[][] = new int[n][m];
        int needed = 0;
        Queue<Coor> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) {
                    needed++;
                }

                if (board[i][j] == 1) {
                    queue.offer(new Coor(i, j, 0));
                }
            }
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            Coor cur = queue.poll();
            int curDay = cur.days;
            
            for (int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m || board[ny][nx] != 0) {
                    continue;
                }

                board[ny][nx] = 1;
                queue.offer(new Coor(ny, nx, curDay + 1));
                needed--;
                answer = curDay + 1;
            }
        }
        
        System.out.println(needed == 0 ? answer : -1);
    }
}