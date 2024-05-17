import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[10000];
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            arr[temp - 1]++;
        }

        for (int i = 0; i < 10000; i++) {
            if (arr[i] == 0) continue;
            for (int j = 0; j < arr[i]; j++) {
                sb.append(i + 1).append("\n");
            }
        }

        System.out.println(sb);
    }
}
