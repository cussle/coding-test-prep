import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;

        while (! (str = br.readLine()).equals("0")) {
            boolean status = true;
            int strLength = str.length();
            int mid = strLength / 2;

            for (int i = 0; i <= mid; i++) {
                if (str.charAt(i) != str.charAt(strLength - i - 1)) {
                    status = false;
                    break;
                }
            }

            if (status) {
                sb.append("yes");
            } else {
                sb.append("no");
            }
            sb.append("\n");
        }
        br.close();
        System.out.println(sb);
    }
}
