import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] lans = new long[K];
        long max = 0;

        for (int i = 0; i < K; i++) {
            lans[i] = Integer.parseInt(br.readLine());
            if (max < lans[i]) max = lans[i];
        }
        br.close();

        long low = 1, high = max, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            long count = 0;

            for (int i = 0; i < K; i++) count += lans[i] / mid;

            if (count >= N) low = mid + 1;
            else high = mid - 1;
        }

        System.out.println(high);
    }
}
