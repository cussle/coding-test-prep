import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            boolean res = true;

            if (temp < 2) res = false;
            for (int j = 2; j <temp; j++) {
                if (temp % j == 0) res = false;
            }
            if(res) cnt++;
        }

        System.out.println(cnt);
    }
}
