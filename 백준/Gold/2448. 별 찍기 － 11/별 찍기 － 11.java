import java.io.*;
import java.util.*;

public class Main {
    static char[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        stars = new char[n][n * 2 - 1];

        printStars(n / 3, 0, n * 2 - 2, 0, n - 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 2 - 1; j++) {
                if (stars[i][j] == '*') {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

        // String input;
        // int cnt = 0;
        // while ((input = br.readLine()) != null) {
        //     System.out.println(input.length());
        //     cnt++;
        // }
        // System.out.println("line count: " + cnt);
    }

    private static void printStars(int n, int l, int r, int t, int b) {
        if (n == 1) {
            int m = (l + r) / 2;
            stars[t][m] = '*';
            stars[t + 1][m - 1] = '*';
            stars[t + 1][m + 1] = '*';
            for (int i = 0; i < 5; i++) {
                stars[t + 2][l + i] = '*';
            }
            return;
        }

        printStars(n / 2, l, l + 2 * ((b - t + 1) / 2) - 2, (t + b + 1) / 2, b);  // 좌하단
        printStars(n / 2, r - 2 * ((b - t + 1) / 2) + 2, r, (t + b + 1) / 2, b);  // 우하단
        printStars(n / 2, l + ((b - t + 1) / 2), r - ((b - t + 1) / 2), t, (t + b) / 2);  // 상단
    }
}
