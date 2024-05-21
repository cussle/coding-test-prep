import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String input = br.readLine();
        br.close();

        int sum = 0;
        int pow = 1;
        for (int i = 0; i < L; i++) {
            sum = (sum + (input.charAt(i) - 'a' + 1) * pow) % 1234567891;
            pow = (pow * 31) % 1234567891;
        }

        System.out.println(sum);
    }
}
