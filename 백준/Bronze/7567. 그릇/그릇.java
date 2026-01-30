import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = input.length();
        int h = 10;
        char cur = input.charAt(0);
        char prev;
        
        for (int i = 1; i < n; i++) {
            prev = cur;
            cur = input.charAt(i);

            if (prev == cur) {
                h += 5;
            } else {
                h += 10;
            }
        }

        System.out.println(h);
    }
}