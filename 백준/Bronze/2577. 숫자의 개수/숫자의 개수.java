import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        br.close();

        String mul = Integer.toString(A * B * C);
        int[] res = new int[10];

        for (int i = 0; i < mul.length(); i++) {
            res[mul.charAt(i) - '0']++;
        }

        for (int re : res) {
            System.out.println(re);
        }
    }
}
