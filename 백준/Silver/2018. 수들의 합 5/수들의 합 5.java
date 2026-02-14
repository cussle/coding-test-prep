import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int l = 1, r = 1;
        long sum = 1;
        int cnt = 0;

        while (l <= n) {
            if (sum == n) {
                cnt++;
                sum -= l;
                l++;
            } else if (sum < n) {
                r++;
                if (r > n) break;
                sum += r;
            } else {
                sum -= l;
                l++;
            }
        }

        System.out.println(cnt);
    }
}
