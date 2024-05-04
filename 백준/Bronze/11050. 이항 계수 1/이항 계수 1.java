import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int nf = 1, nkf = 1, kf = 1;
        for (int i = 1; i <= N; i++) {
            nf *= i;
            if (K >= i) kf *= i;
            if (N - K >= i) nkf *= i;
        }
        System.out.println(nf / nkf / kf);
    }
}
