import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n;
        int answer = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            n = Integer.parseInt(br.readLine());
            answer += n;
            min = Math.min(min, n);
        }

        answer -= min;
        min = Integer.MAX_VALUE;
        for (int i = 0; i < 2; i++) {
            n = Integer.parseInt(br.readLine());
            answer += n;
            min = Math.min(min, n);
        }

        answer -= min;
        System.out.println(answer);
    }
}