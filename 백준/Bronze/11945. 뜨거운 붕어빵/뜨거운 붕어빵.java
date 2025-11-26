import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = m - 1; j >= 0; j--) {
                sb.append(temp.charAt(j));
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}