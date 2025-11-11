import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) - 3;
        boolean needSum = false;

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int temp = b - a;

        if (b + temp == c) {
            needSum = true;
        } else {
            temp = b / a;
        }

        while (n --> 0) {
            c = Integer.parseInt(br.readLine());
        }

        if (needSum) {
            System.out.println(c + temp);
        } else {
            System.out.println(c * temp);
        }
    }
}