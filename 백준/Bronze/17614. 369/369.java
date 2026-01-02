import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int x = i;
            while (x > 0) {
                int cur = x % 10;
                if (cur != 0 && cur % 3 == 0) {
                    answer++;
                }
                x /= 10;
            }
        }

        System.out.println(answer);
    }
}