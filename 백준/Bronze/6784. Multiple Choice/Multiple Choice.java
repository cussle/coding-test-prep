import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] inputs = new char[N];

        for (int n = 0; n < N; n++) {
            inputs[n] = br.readLine().charAt(0);
        }

        int result = 0;
        for (int n = 0; n < N; n++) {
            if (inputs[n] == br.readLine().charAt(0)) {
                result++;
            }
        }

        System.out.println(result);
    }
}
