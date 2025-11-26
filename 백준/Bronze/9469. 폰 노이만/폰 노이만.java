import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int p = Integer.parseInt(br.readLine());
        for (int i = 1; i <= p; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            double d = Double.parseDouble(st.nextToken());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            double f = Double.parseDouble(st.nextToken());

            sb.append(n).append(" ")
                .append(String.format("%.6f", d / (a + b) * f))
                .append("\n");
        }

        System.out.println(sb.toString());
    }
}