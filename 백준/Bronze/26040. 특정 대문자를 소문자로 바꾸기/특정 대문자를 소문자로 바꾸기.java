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

            StringBuilder sb = new StringBuilder();
            for (char c : a.toCharArray()) {
                sb.append(b.contains(c) ? Character.toLowerCase(c) : c);
            }

            System.out.println(sb.toString());
        }
    }