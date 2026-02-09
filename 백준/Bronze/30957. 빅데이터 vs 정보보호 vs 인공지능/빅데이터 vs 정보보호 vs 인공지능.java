import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] asks = new int[3];

        String inputs = br.readLine();
        for (int i = 0; i < n; i++) {
            char c = inputs.charAt(i);
            if (c == 'B') {
                asks[0]++;
            } else if (c == 'S') {
                asks[1]++;
            } else {
                asks[2]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (max < asks[i]) {
                max = asks[i];
            }
        }

        if (asks[0] == max) {
            sb.append('B');
        }
        if (asks[1] == max) {
            sb.append('S');
        }
        if (asks[2] == max) {
            sb.append('A');
        }

        System.out.println(sb.length() == 3 ? "SCU" : sb.toString());
    }
}