import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        while (m --> 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1; 
            int e = Integer.parseInt(st.nextToken()) - 1;
            
            boolean result = true;
            while (s <= e) {
                if (arr[s] != arr[e]) {
                    result = false;
                    break;
                }
                s++;
                e--;
            }

            sb.append(result ? 1 : 0).append("\n");
        }

        System.out.println(sb.toString());        
    }
}