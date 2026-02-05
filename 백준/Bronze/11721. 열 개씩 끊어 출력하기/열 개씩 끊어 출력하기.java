import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        int cnt = 1;
        for (char c : input.toCharArray()) {
            sb.append(c);
            cnt++;

            if (cnt > 10) {
                sb.append("\n");
                cnt = 1;
            }
        }

        System.out.println(sb.toString());
    }
}