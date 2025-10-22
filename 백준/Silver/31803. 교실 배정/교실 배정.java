import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int target = (n % 2 == 0) ? n - 1 : n;
        long answer = 1;

        while (target > 1) {
            answer *= target;
            target -= 2;
        }

        System.out.println(answer);
    }
}