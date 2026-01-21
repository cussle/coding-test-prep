import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int key = input.charAt(0) ^ 'C';

        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            sb.append((char) (c ^ key));
        }
        System.out.println(sb.toString());
    }
}
