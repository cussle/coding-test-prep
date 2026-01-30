import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = 0;
        int idx = -1;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            int sum = 0;
            while (st.hasMoreTokens()) {
                sum += Integer.parseInt(st.nextToken());
            }

            if (sum > max) {
                max = sum;
                idx = i + 1;
            }
        }

        System.out.println(idx + " " + max);
    }
}