import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> cnt = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            cnt.put(name, cnt.getOrDefault(name, 0) + 1);
        }

        for (int i = 0; i < n - 1; i++) {
            String name = br.readLine();
            int left = cnt.get(name) - 1;
            if (left == 0) cnt.remove(name);
            else cnt.put(name, left);
        }

        System.out.println(cnt.keySet().iterator().next());
    }
}
