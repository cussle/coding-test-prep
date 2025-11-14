import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = 0, b = 0;
        StringTokenizer st;

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            a += Integer.parseInt(st.nextToken());
            b += Integer.parseInt(st.nextToken());
        }

        if (a > b) {
            System.out.println("Yongdap");
        } else if (a < b) {
            System.out.println("Hanyang Univ.");
        } else {
            System.out.println("Either");
        }
    }
}