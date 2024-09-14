import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        while (N --> 0) {
            String line = br.readLine();
            char[] chars = line.toCharArray();
            Arrays.sort(chars);
            set.add(Arrays.toString(chars));
        }

        System.out.println(set.size());
    }
}
