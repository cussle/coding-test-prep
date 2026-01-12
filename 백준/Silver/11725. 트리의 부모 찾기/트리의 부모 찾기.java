import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Integer>[] nodes = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            nodes[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes[a].add(b);
            nodes[b].add(a);
        }

        // discover
        int[] parents = new int[n + 1];
        Arrays.fill(parents, -1);
        parents[1] = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 0; i < nodes[cur].size(); i++) {
                int next = nodes[cur].get(i);
                if (parents[next] == -1) {
                    parents[next] = cur;
                    queue.offer(next);
                }
            }
        }

        for (int i = 2; i < n + 1; i++) {
            System.out.println(parents[i]);
        }
    }
}