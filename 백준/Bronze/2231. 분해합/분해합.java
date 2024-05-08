import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        boolean status = false;
        for (int i = 1; i < N; i++) {
            int sum = 0, temp = i;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if (sum + i == N) {
                status = true;
                System.out.println(i);
                break;
            }
        }

        if (!status) {
            System.out.println(0);
        }
    }
}
