import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) % 10;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        while (st.hasMoreTokens()) {
            int m = Integer.parseInt(st.nextToken());
            if (m == n) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}