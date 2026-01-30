import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[n][n];

        // 길이가 1인 경우
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // 길이가 2인 경우
        for (int i = 1; i < n; i++) {
            dp[i - 1][i] = (arr[i - 1] == arr[i]);
        }

        // 길이가 3 이상인 경우
        for (int length = 3; length <= n; length++) {
            for (int end = length - 1; end < n; end++) {
                int start = end - (length - 1);
                dp[start][end] = (arr[start] == arr[end]) && dp[start + 1][end - 1];
            }
        }

        int m = Integer.parseInt(br.readLine());
        while (m --> 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1; 
            int e = Integer.parseInt(st.nextToken()) - 1;
            
            sb.append(dp[s][e] ? 1 : 0).append("\n");
        }

        System.out.println(sb.toString());        
    }
}