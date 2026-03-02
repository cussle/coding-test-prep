import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n --> 0) {
            int len = br.readLine().length();
            if (len >= 6 && len <= 9) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }

        System.out.println(sb.toString());
    }
}
