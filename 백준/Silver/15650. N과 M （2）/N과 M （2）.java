import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int max = n - m + 1;
        for (int i = 1; i <= max; i++) {
            dfs(n, m - 1, i, i);
        }
    }

    private static void dfs(int n, int m, int last, int cur) {
        if (m == 0) {
            printWithSpace(cur);
        }

        for (int i = last + 1; i <= n; i++) {
            dfs(n, m - 1, i, cur * 10 + i);
        }
    }

    private static void printWithSpace(int num) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            sb.insert(0, num % 10);
            if (i != 0) {
                sb.insert(1, " ");
            }
            num /= 10;
            i++;
        }
        System.out.println(sb.toString());
    }
}