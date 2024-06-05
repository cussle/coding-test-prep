import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        int[] size = new int[6];
        for (int i = 0; i < 6; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = 0; i < 6; i++) {
            sum = (size[i] % T == 0) ? sum + (size[i] / T) : sum + (size[i] / T) + 1;
        }
        sb.append(sum).append("\n");
        sb.append(N / P).append(" ").append(N % P);

        System.out.println(sb);
    }
}
