import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] cost = new int[100_002];
        Arrays.fill(cost, Integer.MAX_VALUE);
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerFirst(n);
        cost[n] = 0;

        while(!queue.isEmpty()) {
            int cur = queue.pollFirst();

            if (cur < 0 || cur >= 100_002) {
                continue;
            }

            if (cur * 2 <= 100_000 && cost[cur * 2] > cost[cur]) {
                cost[cur * 2] = cost[cur];
                queue.offerFirst(cur * 2);
            }

            if (cur + 1 <= 100_001 && cost[cur + 1] > cost[cur] + 1) {
                cost[cur + 1] = cost[cur] + 1;
                queue.offerLast(cur + 1);
            }

            if (cur - 1 >= 0 && cost[cur - 1] > cost[cur] + 1) {
                cost[cur - 1] = cost[cur] + 1;
                queue.offerLast(cur - 1);
            }

        }

        System.out.println(cost[k]);
    }
}