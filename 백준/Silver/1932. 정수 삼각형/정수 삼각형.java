import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] inputs = new int[n][];
        int[][] dp = new int[n][];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            inputs[i] = new int[i + 1];
            dp[i] = new int[i + 1];

            for (int j = 0; j < i + 1; j++) {
                inputs[i][j] = Integer.parseInt(st.nextToken());

                if (i == n - 1) {
                    dp[i][j] = inputs[i][j];
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + inputs[i][j];
            }
        }

        System.out.println(dp[0][0]);
    }
}
