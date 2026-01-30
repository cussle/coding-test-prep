import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        boolean[][] a = new boolean[n][n];
        boolean[][] b = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = st.nextToken().charAt(0) == '1';
            }
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                b[i][j] = st.nextToken().charAt(0) == '1';
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean result = false;
                for (int k = 0; k < n; k++) {
                    result = result | (a[i][k] && b[k][j]);
                    if (result) {
                        answer++;
                        break;
                    }
                }
                if (result) {
                    continue;
                }
            }
        }

        System.out.println(answer);
    }
}