import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String input;

        int cnt = 0;
        while (!(input = br.readLine()).equals("0 0 0")) {
            st = new StringTokenizer(input);

            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int answer = v / p * l;
            answer += Math.min(v % p, l);
            sb.append("Case ").append(++cnt).append(": ").append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}
