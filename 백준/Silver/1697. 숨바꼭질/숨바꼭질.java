import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        br.close();

        int[] visited = new int[100001];
        for (int i = 0; i < 100001; i++) {
            visited[i] = -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            visited[temp]++;

            if (temp == K) {
                System.out.println(visited[temp]);
                break;
            }

            if (temp - 1 >= 0 && visited[temp - 1] == -1) {
                visited[temp - 1] = visited[temp];
                queue.add(temp - 1);
            }

            if (temp + 1 <= 100000 && visited[temp + 1] == -1) {
                visited[temp + 1] = visited[temp];
                queue.add(temp + 1);
            }

            if (temp * 2 <= 100000 && visited[temp * 2] == -1) {
                visited[temp * 2] = visited[temp];
                queue.add(temp * 2);
            }
        }
    }
}
