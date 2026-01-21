import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] fail = new boolean[m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                if (fail[j]) {
                    continue;
                }

                if (input.charAt(j) == 'O') {
                    fail[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (!fail[i]) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println("ESCAPE FAILED");
    }
}
