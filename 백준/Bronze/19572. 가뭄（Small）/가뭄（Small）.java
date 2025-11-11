import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int d1 = Integer.parseInt(st.nextToken());  // a + b
        int d2 = Integer.parseInt(st.nextToken());  // a + c
        int d3 = Integer.parseInt(st.nextToken());  // b + c

        double b = (d1 - d2 + d3) / 2.0;
        double a = d1 - b;
        double c = d2 - a;

        if (a > 0 && b > 0 && c > 0) {
            System.out.println("1");
            System.out.println(String.format("%.1f %.1f %.1f", a, b, c));
        } else {
            System.out.println("-1");
        }
    }
}