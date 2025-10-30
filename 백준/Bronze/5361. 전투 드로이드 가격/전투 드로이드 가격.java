import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        double[] prices = {350.34, 230.9, 190.55, 125.3, 180.90};

        while (tc --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double sum = 0;

            for (int i = 0; i < 5; i++) {
                sum += (Double.parseDouble(st.nextToken()) * prices[i]);
            }
            sb.append(String.format("$%.2f\n", sum));
        }

        System.out.println(sb.toString());
    }
}