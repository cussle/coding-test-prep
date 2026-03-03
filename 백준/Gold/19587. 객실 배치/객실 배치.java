import java.io.*;
import java.util.*;

public class Main {

    private static final int MOD = 1000000007;
    private static Map<Long, long[][]> matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        if (n < 2L) {
            System.out.println(3);
            return;
        }

        matrix = new HashMap<>();
        matrix.put(1L, new long[][]{{2L, 1L}, {1L, 0L}});
        
        divide(n - 1);

        long[][] ansMatrix = matrix.get(n - 1);
        long answer = ((ansMatrix[0][0] * 3) % MOD) + ((ansMatrix[0][1] * 1) % MOD);
        System.out.println(answer % MOD);
    }

    private static void divide(long cur) {
        if (cur < 2) {
            return;
        }

        if (matrix.get(cur) != null) {
            return;
        }

        long num1 = cur / 2L;
        long num2 = cur - num1;

        divide(num1);
        divide(num2);

        multiply(num1, num2);
    }

    private static void multiply(long num1, long num2) {
        long res = num1 + num2;

        long[][] temp = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    temp[i][j] += matrix.get(num1)[i][k] * matrix.get(num2)[k][j];
                    temp[i][j] %= MOD;
                }
            }
        }

        matrix.put(res, temp);
    }
}