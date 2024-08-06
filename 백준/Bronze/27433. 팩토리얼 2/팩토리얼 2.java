import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Long result = 1L;

        for (int i = 0; i < N; i++) {
            result *= (i + 1);
        }

        System.out.println(result);
    }
}
