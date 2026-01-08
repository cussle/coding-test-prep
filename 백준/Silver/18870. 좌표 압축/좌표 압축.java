import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int arr[] = new int[n];
        Map<Integer, Integer> map = new TreeMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], 0);
        }

        int idx = 0;
        for (int m : map.keySet()) {
            map.put(m, idx++);
        }

        for (int i = 0; i < n; i++) {
            sb.append(map.get(arr[i]));
            if (i + 1 != n) {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());        
    }
}