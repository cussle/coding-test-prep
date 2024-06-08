import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] inputs = new int[N];
        for (int n = 0; n < N; n++) {
            if (n == 0) {
                inputs[n] = Integer.parseInt(st.nextToken());
            } else {
                inputs[n] = inputs[n - 1] + Integer.parseInt(st.nextToken());
            }
        }

        while (M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (start == 1) {
                sb.append(inputs[end - 1]).append("\n");
            } else {
                sb.append(inputs[end - 1] - inputs[start - 2]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
