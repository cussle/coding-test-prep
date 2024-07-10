import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int[] DP = new int[X + 1];
        for (int i = 0; i < X + 1; i++) {
            DP[i] = -1;
        }

        DP[1] = 0;

        if (X >= 2) {
            DP[2] = 1;
        }

        if(X >= 3) {
            DP[3] = 1;
        }
        
        for (int i = 4; i <= X; i++) {
            DP[i] = 1 + DP[i - 1];

            if (i % 3 == 0) {
                DP[i] = Math.min(DP[i], 1 + DP[i / 3]);
            }

            if (i % 2 == 0) {
                DP[i] = Math.min(DP[i], 1 + DP[i / 2]);
            }
        }

        System.out.println(DP[X]);
    }
}
