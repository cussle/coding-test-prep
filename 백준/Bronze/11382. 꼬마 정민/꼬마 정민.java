import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = 0;

        while (st.hasMoreTokens()) {
            answer += Long.parseLong(st.nextToken());
        }

        System.out.println(answer);
    }

}