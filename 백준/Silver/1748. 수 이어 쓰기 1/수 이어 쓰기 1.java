import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            int cnt = 0;
            while (num > 0) {
                num /= 10;
                cnt++;
            }
            answer += cnt;
        }

        System.out.println(answer);
    }
}
