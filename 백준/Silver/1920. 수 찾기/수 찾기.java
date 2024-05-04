import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        br.close();

        for (int i = 0; i < M; i++) {
            int temp = Integer.parseInt(st.nextToken());

            int low = 0, high = N - 1, mid, res = 0;
            while(low <= high) {
                mid = (low + high) / 2;

                if (arr[mid] == temp) {
                    res = 1;
                    break;
                } else if (arr[mid] > temp) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}
