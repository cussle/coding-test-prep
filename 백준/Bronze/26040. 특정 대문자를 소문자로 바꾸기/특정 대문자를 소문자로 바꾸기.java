import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        Set<Character> b = new HashSet<>();

        for (char c : br.readLine().toCharArray()) {
            b.add(c);
        }

        for (char c : a.toCharArray()) {
            if (b.contains(c)) {
                System.out.print(Character.toLowerCase(c));
                continue;
            }
            System.out.print(c);
        }
    }
}