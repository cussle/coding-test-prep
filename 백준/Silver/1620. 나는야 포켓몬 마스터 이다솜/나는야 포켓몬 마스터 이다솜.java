import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = 1;
        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        while (N --> 0) {
            String temp = br.readLine();
            map1.put(count, temp);
            map2.put(temp, count);
            count++;
        }

        while (M --> 0) {
            String temp = br.readLine();
            try {
                int target = Integer.parseInt(temp);
                sb.append(map1.get(target));
            } catch (Exception e) {
                sb.append(map2.get(temp));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
