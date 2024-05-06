import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int mul = 1, i = 2;
        while (i <= 10000) {
            if (a % i == 0 && b % i == 0) {
                mul *= i;
                a /= i;
                b /= i;
            } else {
                i++;
            }
            if (i > a || i > b) {
                break;
            }
        }
        System.out.println(mul + "\n" + a * b * mul);
    }
}
