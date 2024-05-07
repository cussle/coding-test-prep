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

        int count = 0;
        int patternLength = 2 * N + 1;

        for (int i = 0; i <= M - patternLength; i++) {
            boolean matched = true;
            if (S.charAt(i) == 'I') {
                for (int j = 1; j < patternLength; j++) {
                    if ((j % 2 == 1 && S.charAt(i + j) != 'O') || (j % 2 == 0 && S.charAt(i + j) != 'I')) {
                        matched = false;
                        break;
                    }
                }
                if (matched) count++;
            }
        }
        System.out.println(count);
    }
}
