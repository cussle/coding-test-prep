import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int attackTimeA = Integer.parseInt(st.nextToken());
        int breakTimeA = Integer.parseInt(st.nextToken());
        int periodA = attackTimeA + breakTimeA;
        int attackTimeB = Integer.parseInt(st.nextToken());
        int breakTimeB = Integer.parseInt(st.nextToken());
        int periodB = attackTimeB + breakTimeB;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 3; i++) {
            int arrive = Integer.parseInt(st.nextToken());
            int result = 0;
            int remainA = arrive % periodA;
            int remainB = arrive % periodB;

            if (remainA != 0 && remainA <= attackTimeA) {
                result++;
            }

            if (remainB != 0 && remainB <= attackTimeB) {
                result++;
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());
    }
}
