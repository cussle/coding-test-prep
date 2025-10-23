import java.io.*;
import java.util.*;

public class Main {

    public static class Node {
        int num;
        String req;

        public Node(int num, String req) {
            this.num = num;
            this.req = req;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);

            boolean[] visited = new boolean[10000];
            LinkedList<Node> queue = new LinkedList<Node>();

            queue.add(new Node(a, ""));
            while (! queue.isEmpty()) {
                Node n = queue.poll();
                int cur = n.num;

                if (cur == b) {
                    sb.append(n.req).append("\n");
                    break;
                }

                if (! visited[cur]) {
                    visited[cur] = true;
                    
                    // D
                    int temp = (cur * 2) % 10_000;
                    queue.add(new Node(temp, n.req + "D"));

                    // S
                    temp = cur == 0 ? 9999 : cur - 1;
                    queue.add(new Node(temp, n.req + "S"));

                    // L
                    temp = (cur % 1000) * 10 + (cur / 1000);
                    queue.add(new Node(temp, n.req + "L"));

                    // R
                    temp = (cur / 10) + (cur % 10) * 1000;
                    queue.add(new Node(temp, n.req + "R"));
                }
            }
        }

        System.out.println(sb.toString());
    }
}