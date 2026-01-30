import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            set.remove(st.nextToken());
        }

        System.out.println(set.toArray()[0]);
    }
}