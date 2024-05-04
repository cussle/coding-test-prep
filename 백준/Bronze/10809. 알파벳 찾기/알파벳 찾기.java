import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();

        int[] res = new int[26];
        Arrays.fill(res, -1);
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (res[ch - 'a'] == -1) res[ch- 'a'] = i;
        }

        for (int n : res) {
            System.out.print(n + " ");
        }
    }
}
