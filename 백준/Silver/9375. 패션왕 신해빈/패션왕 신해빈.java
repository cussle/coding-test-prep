import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<String, Integer>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                String temp = st.nextToken();
                map.put(temp, map.getOrDefault(temp, 1) + 1);
            }

            int res = 1;
            for (int cnt : map.values()) {
                res *= cnt;
            }
            res--;

            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}
