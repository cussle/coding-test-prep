import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            long m = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());

            if (m == 0 && n == 0) {
                break;
            }
            m++;
            n++;

            long t = (Math.min(m, n) + 1) / 2;

            BigInteger T = BigInteger.valueOf(t);
            BigInteger T2 = T.multiply(T);
            BigInteger T4 = T2.multiply(T2);

            BigInteger termA = T4.multiply(BigInteger.valueOf(2)).subtract(T2);
            BigInteger termB = BigInteger.valueOf(m + n).multiply(T).multiply(BigInteger.valueOf(4).multiply(T2).subtract(BigInteger.ONE)).divide(BigInteger.valueOf(3));
            BigInteger termC = BigInteger.valueOf(m * n).multiply(T2);

            // System.out.println("t: " + t);
            // System.out.println("T: " + T);
            // System.out.println("T2: " + T2);
            // System.out.println("T4: " + T4);
            // System.out.println("termA: " + termA);
            // System.out.println("termB: " + termB);
            // System.out.println("termC: " + termC);

            BigInteger answer = termA.subtract(termB).add(termC);
            sb.append(answer.toString()).append("\n");
        }

        System.out.println(sb.toString());
    }
}
