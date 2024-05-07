import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        br.close();

        int result = 0;
        int count = 0;

        for (int i = 1; i < M - 1; i++) {
            if (S.charAt(i-1) == 'I' && S.charAt(i) == 'O' && S.charAt(i+1) == 'I') {
                count++;
                if (count == N) {
                    result++;
                    count--;
                }
                i++;
            } else {
                count = 0;
            }
        }

        System.out.println(result);
    }
}
