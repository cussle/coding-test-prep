import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 1; i <= N; i++) {
            arr[i - 1] = i;
        }

        while (M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int i = start - 1; i < start - 1 + (end - start + 1) / 2; i++) {
                int temp = arr[i];
                arr[i] = arr[end - 1 - (i - (start - 1))];
                arr[end - 1 - (i - (start - 1))] = temp;
            }
        }

        for (int i : arr) {
            sb.append(i).append(" ");
        }
        sb.append("\n");
        System.out.println(sb);
    }
}
