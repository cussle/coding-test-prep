import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int sum = Integer.parseInt(st.nextToken());
        int sub = Integer.parseInt(st.nextToken());

        boolean isEven = (sum + sub) % 2 == 0;

        if (isEven) {
            int a = (sum + sub) / 2;
            int b = sum - a;

            if (a >= 0 && b >= 0) {
                sb.append(a).append(" ").append(b);
            } else {
                sb.append(-1);
            }
        } else {
            sb.append(-1);
        }

        System.out.println(sb.toString() + "\n");
    }
}
