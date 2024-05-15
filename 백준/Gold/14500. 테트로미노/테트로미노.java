import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int res;
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        res = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, arr[i][j], 1);
                visited[i][j] = false;
                extraShape(i, j);
            }
        }

        System.out.println(res);
    }

    public static void dfs(int x, int y, int sum, int depth) {
        if (depth == 4) {
            res = Math.max(res, sum);
            return;
        }

        for (int i = 0;i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, sum + arr[nx][ny], depth + 1);
                visited[nx][ny] = false;
            }
        }
    }

    public static void extraShape(int x, int y) {
        int[][] shape = {
            {-1, 0},
            {0, 0},
            {1, 0},
            {0, -1}
        };

        for (int i = 0; i < 4; i++) {
            shape = rotateShape(shape);
            int sum = 0;
            boolean isValid = true;
            for (int[] block : shape) {
                int nx = x + block[0];
                int ny = y + block[1];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    sum += arr[nx][ny];
                } else {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                res = Math.max(res, sum);
            }
        }
    }

    public static int[][] rotateShape(int[][] origin) {
        int[][] rotated = new int[4][2];
        for (int i = 0; i < 4; i++) {
            rotated[i][0] = origin[i][1];
            rotated[i][1] = -origin[i][0];
        }
        return rotated;
    }
}
