import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long answer = Arrays.stream(br.readLine().split(" "))
            .map(Integer::parseInt)
            .reduce(0, (t, n) -> t + Integer.parseInt("1".repeat(n)));
        
        System.out.println(answer);
    }
}