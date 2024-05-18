import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();

        HashSet<String> set = new HashSet<>();
        set.add("c=");
        set.add("c-");
        set.add("dz=");
        set.add("d-");
        set.add("lj");
        set.add("nj");
        set.add("s=");
        set.add("z=");

        boolean[] visited = new boolean[str.length()];
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i + 2 < str.length() && set.contains(str.substring(i, i + 3))) {
                i += 2;
            } else if (i + 1 < str.length() && set.contains(str.substring(i, i + 2))) {
                i += 1;
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
