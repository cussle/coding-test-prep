import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Math.abs(a) + Math.abs(b);

        if (d <= c && (c - d) % 2 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}