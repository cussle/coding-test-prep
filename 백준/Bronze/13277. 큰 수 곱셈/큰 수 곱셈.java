import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger answer = Arrays.stream(br.readLine().split(" "))
                            .map(BigInteger::new)
                            .reduce(BigInteger.ONE, BigInteger::multiply);

        System.out.println(answer);
    }
}