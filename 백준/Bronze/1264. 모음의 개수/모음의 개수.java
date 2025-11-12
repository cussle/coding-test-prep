import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine().toLowerCase();
            if (input.equals("#")) {
                break;
            }

            int answer = 0;
            for (char c : input.toCharArray()) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}