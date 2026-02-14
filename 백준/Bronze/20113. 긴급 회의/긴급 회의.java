import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] vote = new int[n];

        int max = Integer.MIN_VALUE;
        int target = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int temp;
        while (st.hasMoreTokens()) {
            temp = Integer.parseInt(st.nextToken());
            if (temp == 0) {
                continue;
            }
            temp--;
            vote[temp]++;

            if (vote[temp] == max) {
                target = -1;
            }

            if (vote[temp] > max) {
                max = vote[temp];
                target = temp;
            }
        }

        System.out.println(target == -1 ? "skipped" : target + 1);
    }
}