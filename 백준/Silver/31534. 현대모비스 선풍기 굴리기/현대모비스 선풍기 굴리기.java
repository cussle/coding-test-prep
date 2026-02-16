import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        double h = Double.parseDouble(st.nextToken());

        if (a == b) {
            System.out.println(-1);
            return;
        }

        double x = a * h / (b - a);
        double ySquare = Math.pow(x + h, 2) + Math.pow(b, 2);
        double zSquare = Math.pow(x, 2) + Math.pow(a, 2);

        System.out.println((ySquare - zSquare) * Math.PI);
    }
}
