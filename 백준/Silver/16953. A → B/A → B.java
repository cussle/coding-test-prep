import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        System.out.println(dfs(a, b, 1));
    }

    private static int dfs(long n, long target, int depth) {
        if (n > target) {
            return -1;
        }

        if (n == target) {
            return depth;
        }

        int case1 = dfs(n * 2, target, depth + 1);
        int case2 = dfs(n * 10 + 1, target, depth + 1);

        if (case1 == -1 && case2 == -1) {
            return -1;
        } else if (case1 == -1) {
            return case2;
        } else if (case2 == -1) {
            return case1;
        } else {
            return Math.min(case1, case2);
        }
    }
}