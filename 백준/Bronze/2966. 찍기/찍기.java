import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        String answer = br.readLine();
        String a = "ABC";
        String b = "BABC";
        String c = "CCAABB";

        int[] result = new int[3];
        for (int i = 0; i < length; i++) {
            char temp = answer.charAt(i);

            if (temp == a.charAt(i % 3)) {
                result[0]++;
            }
            if (temp == b.charAt(i % 4)) {
                result[1]++;
            }
            if (temp == c.charAt(i % 6)) {
                result[2]++;
            }
        }

        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (max < result[i]) {
                max = result[i];
            }
        }

        System.out.println(max);
        if (result[0] == max) {
            System.out.println("Adrian");
        }
        if (result[1] == max) {
            System.out.println("Bruno");
        }
        if (result[2] == max) {
            System.out.println("Goran");
        }
    }
}