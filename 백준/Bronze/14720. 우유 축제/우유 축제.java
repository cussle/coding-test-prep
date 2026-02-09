import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int idx = 0;
        int answer = 0;
        while (st.hasMoreTokens()) {
            if (idx == st.nextToken().charAt(0) - '0') {
                answer++;
                idx++;
            }
            if (idx > 2) {
                idx = 0;
            }
        }

        System.out.println(answer);
    }
}