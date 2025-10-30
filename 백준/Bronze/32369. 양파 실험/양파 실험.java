import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int onion1 = 1;
        int onion2 = 1;
        for (int i = 0; i < n; i++) {
            onion1 += a;
            onion2 += b;

            if (onion2 > onion1) {
                int temp = onion2;
                onion2 = onion1;
                onion1 = temp;
            }

            if (onion1 == onion2) {
                onion2--;
            }
        }

        System.out.println(onion1 + " " + onion2);
    }
}