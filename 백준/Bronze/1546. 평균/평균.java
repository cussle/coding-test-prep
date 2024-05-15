import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        br.close();

        int max = 0;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp > max) max = temp;
            arr[i] = temp;
        }

        double sum = 0;
        for (int score : arr) {
            sum += (double) score / max * 100;
        }
        System.out.println(sum / N);
    }
}
