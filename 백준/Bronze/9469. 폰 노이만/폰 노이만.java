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
            float d = Float.parseFloat(st.nextToken());
            float a = Float.parseFloat(st.nextToken());
            float b = Float.parseFloat(st.nextToken());
            float f = Float.parseFloat(st.nextToken());

            sb.append(i).append(" ").append(d / (a + b) * f).append("\n");
        }

        System.out.println(sb.toString());
    }
}