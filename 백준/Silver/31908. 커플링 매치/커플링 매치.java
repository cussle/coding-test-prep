import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<String, StringBuilder> map = new LinkedHashMap<>();
        String name, distinct;

        while (N --> 0) {
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            distinct = st.nextToken();

            if (!distinct.equals("-")) {
                if (map.containsKey(distinct)) {
                    map.put(distinct, map.get(distinct).append(" ").append(name));
                } else {
                    map.put(distinct, new StringBuilder().append(name));
                }
            }
        }

        List<String> names = new LinkedList<>();

        for (String s : map.keySet()) {
            st = new StringTokenizer(map.get(s).toString());

            if (st.countTokens() == 2) {
                names.add(map.get(s).toString());
            }
        }

        sb.append(names.size()).append("\n");
        for (String s : names) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
