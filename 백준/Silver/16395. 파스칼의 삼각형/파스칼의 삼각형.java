import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken()) - 1;

        long result = 1;

        for (int i = 0; i < n - k; i++) {
            result *= (n - i);
            result /= (i + 1);

//            System.out.println("곱하기 " + (n - i) + " 나누기 " + (i + 1) + " = " + result);
        }

        System.out.println(result);
    }
}
