import java.io.*;
import java.util.*;

public class Main {

    private static Map<Long, int[][]> matrix;
    private static int n;
    private static long b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());

        matrix = new HashMap<Long, int[][]>();
        matrix.put(1L, new int[n][n]);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[][] cur = matrix.get(1L);
            for (int j = 0; j < n; j++) {
                cur[i][j] = Integer.parseInt(st.nextToken());
                cur[i][j] %= 1000;
            }
        }

        divide(b);

        int[][] answer = matrix.get(b);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void divide(Long cur) {
        if (cur < 2L) {
            return;
        }

        long num1 = cur / 2;
        long num2 = cur - num1;

        if (matrix.get(num1 + num2) != null) {
            return;
        }

        divide(num1);
        divide(num2);

        multiply(num1, num2);
    }

    private static void multiply(long num1, long num2) {
        long res = num1 + num2;

        int[][] cur = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    cur[i][j] += matrix.get(num1)[i][k] * matrix.get(num2)[k][j];
                    cur[i][j] %= 1000;
                }
            }
        }

        matrix.put(res, cur);
    }
}