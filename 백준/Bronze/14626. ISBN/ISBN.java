import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int sum = 0;
        boolean isEven = false;
        for (int i = 0; i < 13; i++) {
            char temp = input.charAt(i);
            if (temp == '*') {
                isEven = i % 2 == 0;
                continue;
            }
            int w = i % 2 == 0 ? 1 : 3;
            sum += (temp - '0') * w;
        }

        for (int i = 0; i < 10; i++) {
            if (isEven) {
                if ((sum + i) % 10 == 0) {
                    System.out.println(i);
                    break;
                }
            } else {
                if ((sum + i * 3) % 10 == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}