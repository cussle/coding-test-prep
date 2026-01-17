import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] tailValue = new int[n];
        int[] tailIdx = new int[n];
        int length = 0;
        int[] prev = new int[n];
        Arrays.fill(prev, -1);

        for (int i = 0; i < n; i++) {
            int cur = a[i];
            int pos = find(tailValue, length, cur);

            tailValue[pos] = cur;
            tailIdx[pos] = i;
            
            if (pos > 0) {
                prev[i] = tailIdx[pos - 1];
            }

            if (pos == length) {
                length++;
            }
        }

        int[] answer = new int[length];
        int idx = tailIdx[length - 1];

        for (int i = length - 1; i >= 0; i--) {
            answer[i] = a[idx];
            idx = prev[idx];
        }

        System.out.println(length);
        for (int i = 0; i < length; i++) {
            System.out.print(answer[i] + " ");
        }
        // System.out.println("\n\n\n\n");

        // System.out.println(length);
        // System.out.println("\n\n");
        // for (int i = 0; i < n; i++) {
        //     System.out.println(prev[i]);
        // }
        // System.out.println("\n\n");
        // for (int i = 0; i < n; i++) {
        //     System.out.println(tailValue[i]);
        // }
        // System.out.println("\n\n");
        // for (int i = 0; i < n; i++) {
        //     System.out.println(tailIdx[i]);
        // }
        // System.out.println("\n\n");
    }

    static private int find(int[] arr, int length, int value) {
        int l = 0;
        int r = length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] >= value) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}