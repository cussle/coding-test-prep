import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int grid[][] = new int[n][m];
        int dist[][][] = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j) - '0';
                dist[i][j][0] = -1;
                dist[i][j][1] = dist[i][j][0];
            }
        }
        dist[0][0][0] = 1;

        int dy[] = {1, -1, 0, 0};
        int dx[] = {0, 0, 1, -1};
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0});

        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];
            int broken = cur[2];

            for (int d = 0; d < 4; d++) {
                int ny = cy + dy[d];
                int nx = cx + dx[d];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                    continue;
                }
                
                if (grid[ny][nx] == 0 && dist[ny][nx][broken] == -1) {
                    dist[ny][nx][broken] = dist[cy][cx][broken] + 1;
                    queue.offer(new int[]{ny, nx, broken});
                }

                if (grid[ny][nx] == 1 && broken == 0 && dist[ny][nx][1] == -1) {  // need to break wall
                    dist[ny][nx][1] = dist[cy][cx][0] + 1;
                    queue.offer(new int[]{ny, nx, 1});
                }
            }
        }

        int answer = -1;
        if (dist[n - 1][m - 1][0] == -1 && dist[n - 1][m - 1][1] != -1) {
            answer = dist[n - 1][m - 1][1];
        } else if (dist[n - 1][m - 1][0] != -1 && dist[n - 1][m - 1][1] == -1) {
            answer = dist[n - 1][m - 1][0];
        } else if (dist[n - 1][m - 1][0] != -1 && dist[n - 1][m - 1][1] != -1) {
            answer = Math.min(dist[n - 1][m - 1][0], dist[n - 1][m - 1][1]);
        }

        System.out.println(answer);

        // System.out.println("\n\n\n\n\n= = = = = D E B U G = = = = =\n");
        // System.out.println("--- grid ---");
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(grid[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        // System.out.println("--- dist (not broken) ---");
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(dist[i][j][0] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        // System.out.println("--- dist (broken) ---");
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(dist[i][j][1] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
    }
}