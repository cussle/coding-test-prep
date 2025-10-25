import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String temp = br.readLine();
        StringTokenizer st = new StringTokenizer(temp);
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;

        int answer = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;

            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;

            if (max + 1 > answer) {
                answer = max + 1;
            }

            // System.out.println(i + ": " + dp[i]);
        }

        System.out.println(answer);
    }
}