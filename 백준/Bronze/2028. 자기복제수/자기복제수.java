import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t --> 0) {
            int n = Integer.parseInt(br.readLine());
            int nSquare = n * n;

            int mod = 1;
            int temp = n;
            while (temp > 0) {
                mod *= 10;
                temp /= 10;
            }

            if (n == nSquare % mod) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.println(sb.toString());
    }
}
