import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        char[][] inputs = new char[N][N];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                inputs[i][j] = temp.charAt(j);
            }
        }

        int cnt = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                cnt++;

                visited[i][j] = true;
                queue.add(new int[] {i, j});

                while (! queue.isEmpty()) {
                    int[] current = queue.poll();
                    int cx = current[1];
                    int cy = current[0];

                    for (int d = 0; d < 4; d++) {
                        int nx = cx + dx[d];
                        int ny = cy + dy[d];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < N && inputs[cy][cx] == inputs[ny][nx] && !visited[ny][nx]) {
                            queue.add(new int[] {ny, nx});
                            visited[ny][nx] = true;
                        }
                    }
                }
            }
        }
        sb.append(cnt).append(" ");

        cnt = 0;
        visited = new boolean[N][N];
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                cnt++;

                visited[i][j] = true;
                queue.add(new int[] {i, j});

                while (! queue.isEmpty()) {
                    int[] current = queue.poll();
                    int cx = current[1];
                    int cy = current[0];

                    for (int d = 0; d < 4; d++) {
                        int nx = cx + dx[d];
                        int ny = cy + dy[d];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[ny][nx]) {
                            boolean status = false;
                            if (inputs[cy][cx] == 'R' && (inputs[ny][nx] == 'R' || inputs[ny][nx] == 'G')) {
                                status = true;
                            } else if (inputs[cy][cx] == 'G' && (inputs[ny][nx] == 'R' || inputs[ny][nx] == 'G')) {
                                status = true;
                            } else if (inputs[cy][cx] == inputs[ny][nx]) {
                                status = true;
                            }
                            if (status) {
                                queue.add(new int[] {ny, nx});
                                visited[ny][nx] = true;
                            }
                        }
                    }
                }
            }
        }
        sb.append(cnt).append("\n");
        System.out.println(sb);
    }
}
