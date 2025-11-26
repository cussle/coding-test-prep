import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t --> 0) {
            st = new StringTokenizer(br.readLine());
            long op1 = Long.parseLong(st.nextToken());
            char op = st.nextToken().charAt(0);
            long op2 = Long.parseLong(st.nextToken());
            st.nextToken();
            long claim = Long.parseLong(st.nextToken());
            long ans = 0L;

            if (op == '+') {
                ans = op1 + op2;
            }

            if (op == '-') {
                ans = op1 - op2;
            }

            if (op == '*') {
                ans = op1 * op2;
            }

            if (op == '/') {
                ans = op1 / op2;
            }

            if (ans == claim) {
                sb.append("correct");
            } else {
                sb.append("wrong answer");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}