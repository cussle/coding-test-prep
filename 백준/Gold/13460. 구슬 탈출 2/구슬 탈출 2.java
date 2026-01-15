import java.io.*;
import java.util.*;

public class Main {

    static class State {
        int ry, rx, by, bx, depth;
        State (int ry, int rx, int by, int bx, int depth) {
            this.ry = ry;
            this.rx = rx;
            this.by = by;
            this.bx = bx;
            this.depth = depth;
        }
    }

    static class Roll {
        int y, x, steps;
        boolean inHole;
        Roll (int y, int x, int steps, boolean inHole) {
            this.y = y;
            this.x = x;
            this.steps = steps;
            this.inHole = inHole;
        }
    }

    static int n, m;
    static char[][] map;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new char[n][m];
        int sry = -1, srx = -1, sby = -1, sbx = -1;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                if (c == 'R') {
                    sry = i;
                    srx = j;
                    map[i][j] = '.';
                } else if (c == 'B') {
                    sby = i;
                    sbx = j;
                    map[i][j] = '.';
                } else {
                    map[i][j] = c;
                }
            }
        }

        System.out.println(bfs(sry, srx, sby, sbx));
        // System.out.println("\n\n = = = = Debug = = = =");
        // System.out.println("Target Y, X: " + target[0] + ", " + target[1]);
        // System.out.println("best: " + best);
        // System.out.println("RY, RX: " + cur.ry + ", " + cur.rx);
        // System.out.println("BY, BX: " + cur.by + ", " + cur.bx);
        // System.out.println();
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(board[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(visited[i][j] + " ");
        //     }
        //     System.out.println();
        // }
    }

    private static int bfs(int sry, int srx, int sby, int sbx) {
        boolean[][][][] visited = new boolean[n][m][n][m];
        Queue<State> q = new ArrayDeque<>();

        visited[sry][srx][sby][sbx] = true;
        q.add(new State(sry, srx, sby, sbx, 0));

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.depth == 10) continue;

            for (int d = 0; d < 4; d++) {
                Roll r = roll(cur.ry, cur.rx, d);
                Roll b = roll(cur.by, cur.bx, d);

                if (b.inHole) continue;
                if (r.inHole) return cur.depth + 1;

                if (r.y == b.y && r.x == b.x) {
                    if (r.steps > b.steps) {
                        r.y -= dy[d];
                        r.x -= dx[d];
                    } else {
                        b.y -= dy[d];
                        b.x -= dx[d];
                    }
                }

                if (!visited[r.y][r.x][b.y][b.x]) {
                    visited[r.y][r.x][b.y][b.x] = true;
                    q.add(new State(r.y, r.x, b.y, b.x, cur.depth + 1));
                }
            }
        }

        return -1;
    }
    
    private static Roll roll(int sy, int sx, int d) {
        int y = sy, x = sx;
        int steps = 0;

        while (true) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) break;
            if (map[ny][nx] == '#') break;

            y = ny;
            x = nx;
            steps++;

            if (map[y][x] == 'O') {
                return new Roll(y, x, steps, true);
            }
        }
        return new Roll(y, x, steps, false);
    }
}