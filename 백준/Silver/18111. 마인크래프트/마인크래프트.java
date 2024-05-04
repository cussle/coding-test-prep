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
        int B = Integer.parseInt(st.nextToken());

        int[][] ground = new int[N][M];
        int min = 256, max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                if (min > ground[i][j]) min = ground[i][j];
                if (max < ground[i][j]) max = ground[i][j];
            }
        }
        br.close();

        int t = Integer.MAX_VALUE, h = 256;
        // 가능한 모든 경우의 수 계산
        for (int i = min; i <= max; i++) {
            int time = 0, blocks = B;
            // ground 순회
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    // 현재 좌표의 블록이 i보다 높을 경우, 제거
                    if (ground[j][k] > i) {
                        int removedBlocks = ground[j][k] - i;
                        time += removedBlocks * 2;
                        blocks += removedBlocks;
                    }

                    // 현재 좌표의 블록이 i보다 낮을 경우, 채우기
                    if (ground[j][k] < i) {
                        int filledBlocks = i - ground[j][k];
                        time += filledBlocks;
                        blocks -= filledBlocks;
                    }
                }
            }

//            System.out.println("[높이: " + i + "] 소요 시간: " + time + ", 현재 블록: " + blocks);

            if (blocks < 0) break;

            if (time < t) {
                t = time;
                h = i;
            } else if ((time == t) && (h < i)) {
                h = i;
            }
        }

        System.out.println(t + " " + h);
    }
}
