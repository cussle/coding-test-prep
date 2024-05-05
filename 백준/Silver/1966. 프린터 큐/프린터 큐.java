import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        LinkedList<int[]> queue = new LinkedList<>();
        
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            queue.clear();
            for (int j = 0; j < N; j++) {
                queue.addLast(new int[] {j, Integer.parseInt(st.nextToken())});
            }

            int cnt = 0;
            while (!queue.isEmpty()) {
                int[] front = queue.poll();
                boolean isPrinted = true;

                for (int[] doc : queue) {
                    if (doc[1] > front[1]) {
                        isPrinted = false;
                        break;
                    }
                }

                if (isPrinted) {
                    cnt++;
                    if (front[0] == M) {
                        sb.append(cnt).append("\n");
                        break;
                    }
                } else {
                    queue.addLast(front);
                }
            }
        }
        br.close();
        System.out.println(sb);
    }
}
