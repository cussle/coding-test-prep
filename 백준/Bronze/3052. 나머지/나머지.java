import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] res = new int[42];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int temp = 0;
        for (int i = 0; i < 10; i++) {
            temp = Integer.parseInt(br.readLine());
            res[temp % 42] = 1;
        }

        int sum = 0;
        for (int n : res) {
            sum += n;
        }

        System.out.println(sum);
    }
}
