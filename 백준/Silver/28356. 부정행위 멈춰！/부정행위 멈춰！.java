import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n == 1 && m == 1) {
            sb.append("1\n");
            sb.append("1\n");
        } else if (n == 1) {
            sb.append("2\n");
            for (int i = 0; i < m; i++) {
                sb.append(i % 2 + 1).append(" ");
            }
        }  else if (m == 1) {
            sb.append("2\n");
            for (int i = 0; i < n; i++) {
                sb.append(i % 2 + 1).append("\n");
            }
        } else {
            sb.append("4\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    sb.append(i % 2 * 2 + j % 2 + 1).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
