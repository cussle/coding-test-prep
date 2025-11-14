import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        BigInteger[] fib = new BigInteger[n + 1];
        fib[1] = BigInteger.ONE;
        if (n >= 2) fib[2] = BigInteger.ONE;
        for (int i = 3; i <= n; i++) {
            fib[i] = fib[i - 1].add(fib[i - 2]);
        }

        System.out.println(fib[n]);
    }
}