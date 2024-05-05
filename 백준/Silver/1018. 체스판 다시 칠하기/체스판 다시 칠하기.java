import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] arr = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'W') arr[i][j] = true;
                else arr[i][j] = false;
            }
        }
        br.close();

        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                // 첫 시작점: i, j
                int count = 0;
                boolean current = arr[i][j];
                for (int x = i; x < i + 8; x++) {
                    for (int y = j; y < j + 8; y++) {
                        // 순회 좌표: x, y
                        if(current != arr[x][y]) {
                            count++;
                        }
                        current = !(current);
                    }
                    current = !(current);
                }
                count = Integer.min(count, 64 - count);
                minCount = Integer.min(minCount, count);
            }
        }

        System.out.println(minCount);
    }
}
