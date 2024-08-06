import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            sb.append(i).append("\n");
        }
        System.out.println(sb.toString());
//        Map<String, Integer> prefixMap = new HashMap<>();
//        for (int i = 0; i < input.length(); i++) {
//            prefixMap.put(input.substring(0, i + 1), i);
//        }
//
//        List<String> prefixSet = new ArrayList<>(prefixMap.keySet());
//        Collections.sort(prefixSet);
//
//        for (int i = 0; i < input.length(); i++) {
//            sb.append(prefixMap.get(prefixSet.get(i))).append("\n");
//        }
//        System.out.println(prefixMap.toString());
//        System.out.println(sb.toString());
    }
}
