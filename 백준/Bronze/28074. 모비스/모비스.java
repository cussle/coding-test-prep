import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> words = Set.of('M', 'O', 'B', 'I', 'S');
        Set<Character> inputs = new HashSet<>();

        for (char c : br.readLine().toCharArray()) {
            inputs.add(c);
        }
        
        System.out.println(inputs.containsAll(words) ? "YES" : "NO");
    }
}