import java.io.*;
import java.util.*;

public class Main {
    
    private static final int MAX = 318_137;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        boolean[] visited = new boolean[MAX + 1];
        boolean[] isDec = new boolean[MAX + 1];
        int[] map = new int[3000];
        
        int cnt = 0;
        int idx = 0;
        for (int i = 2; i <= MAX; i++) {
            if (visited[i]) {
                continue;
            }

            cnt++;
            isDec[i] = true;

            if (isDec[cnt]) {
                map[idx++] = i;
            }

            int cur = 1;
            while (cur * i <= MAX) {
                visited[cur * i] = true;
                cur++;
            }
        }

        int t = Integer.parseInt(br.readLine());
        while (t --> 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(map[n - 1]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
