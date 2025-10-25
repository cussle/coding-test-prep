import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t --> 0) {
            br.readLine();
            Set<String> note1 = Arrays.stream(br.readLine().split(" "))
                                .collect(Collectors.toSet());

            br.readLine();
            String[] note2 = Arrays.stream(br.readLine().split(" "))
                                    .toArray(String[]::new);

            for (String word : note2) {
                if (note1.contains(word)) {
                    sb.append("1").append("\n");
                    continue;
                }
                sb.append("0").append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}