import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] checks = new boolean[101];
        while (st.hasMoreTokens()) {
            int index = Integer.parseInt(st.nextToken());
            if (!checks[index]) {
                checks[index] = true;
            } else {
                answer++;
            }
        }

        System.out.println(answer);
    }
}