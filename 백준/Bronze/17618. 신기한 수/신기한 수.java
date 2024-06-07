import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int result = 0;
        for (int i = 1; i <= N; i++) {
            int n = i, sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            if (i % sum == 0) result++;
        }

        System.out.println(result);
    }
}
