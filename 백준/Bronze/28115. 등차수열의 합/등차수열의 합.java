import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        if (n < 2) {
            System.out.println("YES\n" + br.readLine() + "\n0");
            return;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb.append("YES\n");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        sb.append(a).append(" ").append(b).append(" ");
        int diff = b - a;

        int temp;
        while (st.hasMoreTokens()) {
            a = b;
            b = Integer.parseInt(st.nextToken());

            if (b - a != diff) {
                System.out.println("NO");
                return;
            }

            sb.append(b).append(" ");
        }

        sb.append("\n").append("0 ".repeat(n));
        System.out.println(sb.toString());
    }
}