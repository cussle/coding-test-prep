import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        br.close();

        int[] inputs = new int[N];
        int index = 0, res = 0;
        while(st.hasMoreTokens()) {
            inputs[index++] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == i) continue;
                for (int k = 0; k < N; k++) {
                    if (k == i) continue;
                    if (k == j) continue;
                    int sum = inputs[i] + inputs [j] + inputs[k];
                    if ((sum <= M) && (sum > res)) res = sum;
                }
            }
        }

        System.out.println(res);
    }
}
