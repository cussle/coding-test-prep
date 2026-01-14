import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(br.readLine());

            sb.append("Case #").append(i + 1).append(": ");
            if (cur > 4500) {
                sb.append("Round 1");
            } else if (cur > 1000) {
                sb.append("Round 2");
            } else if (cur > 25) {
                sb.append("Round 3");
            } else {
                sb.append("World Finals");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}