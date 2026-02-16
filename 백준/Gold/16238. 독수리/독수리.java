import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int time = 0;
        int answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] - time <= 0) {
                break;
            }

            answer += (arr[i] - time);
            // System.out.println(arr[i] - time + " 더함");
            time++;
        }
        System.out.println(answer);
    }
}
