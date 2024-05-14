import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] arr = new int[M][N];
            boolean[][] visited = new boolean[M][N];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int tempX = Integer.parseInt(st.nextToken());
                int tempY = Integer.parseInt(st.nextToken());
                arr[tempX][tempY] = 1;
            }

            int count = 0;
            int[] dx = {0, -1, 0, 1};
            int[] dy = {1, 0, -1, 0};
            Queue<int[]> queue = new LinkedList<>();

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] || arr[i][j] == 0) {
                        continue;
                    }
                    count++;
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int cx = current[0];
                        int cy = current[1];

                        for (int d = 0; d < 4; d++) {
                            int nx = cx + dx[d];
                            int ny = cy + dy[d];

                            if (nx >= 0 && ny >= 0 && nx < M && ny < N && arr[nx][ny] == 1 && !visited[nx][ny]) {
                                queue.add(new int[] {nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
