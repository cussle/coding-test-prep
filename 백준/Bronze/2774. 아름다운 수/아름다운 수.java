import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        boolean[] map = new boolean[10];
        String input;
        int length, cnt;
        while (t --> 0) {
            input = br.readLine();
            length = input.length();
            cnt = 0;

            for (int i = 0; i < length; i++) {
                map[input.charAt(i) - '0'] = true;
            }

            for (int i = 0; i < 10; i++) {
                if (map[i]) {
                    cnt++;
                    map[i] = false;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}