import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t --> 0) {
            int n = Integer.parseInt(br.readLine());
            int sum = 0;

            while (n --> 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int temp = 0;

                while (st.hasMoreTokens()) {
                    int cur = Integer.parseInt(st.nextToken());

                    if (cur > temp) {
                        temp = cur;
                    }
                }

                sum += temp;
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb.toString());
    }
}