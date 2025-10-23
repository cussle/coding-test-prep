import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long answer = Arrays.stream(br.readLine().split(" "))
                            .map(Integer::parseInt)
                            .filter(x -> x == 9)
                            .count();
        System.out.println(answer > 0 ? "F" : "S");
    }
}