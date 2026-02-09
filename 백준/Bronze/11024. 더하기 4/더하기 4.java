import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        while (n --> 0) {
            int temp = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                temp += Integer.parseInt(st.nextToken());
            }
            sb.append(temp).append("\n");
        }

        System.out.println(sb.toString());
    }
}