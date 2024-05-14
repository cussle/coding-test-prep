import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[][] DP = new int[41][2];

    public static int[] sumArr(int[] A, int[] B) {
        int[] newArr = new int[2];
        for (int i = 0; i < 2; i++) {
            newArr[i] = A[i] + B[i];
        }
        return newArr;
    }

    public static int[] fibo(int n) {
        if (DP[n][0] != -1) return DP[n];

        if (n == 0) {
            DP[n] = new int[] {1, 0};
        } else if (n == 1) {
            DP[n] = new int[] {0, 1};
        } else {
            DP[n] = sumArr(fibo(n - 1), fibo(n - 2));
        }
        return DP[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < 41; i++) {
            DP[i][0] = -1;
            DP[i][1] = -1;
        }

        while (T --> 0) {
            int temp = Integer.parseInt(br.readLine());
            int[] res = fibo(temp);
            sb.append(res[0]).append(" ").append(res[1]).append("\n");
        }
        System.out.println(sb);
    }

}
