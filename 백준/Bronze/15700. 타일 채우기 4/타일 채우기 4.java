import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        long answer = n / 2 * m;
        if (n % 2 == 1) {
            answer += m / 2;
        }

        System.out.println(answer);
    }
}