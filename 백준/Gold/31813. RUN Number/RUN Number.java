import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            long N = Integer.parseInt(st.nextToken());
            String K = st.nextToken();
            long intK = Long.parseLong(K);

            ArrayList<Long> res = new ArrayList<>();
            while (intK > 0) {
                int temp = K.charAt(0) - '0';
                boolean found = false;
                for (int j = temp; j > 0 && !found; j--) {
                    long cand = Long.parseLong(String.valueOf(j).repeat(K.length()));
                    if (cand <= intK) {
                        res.add(cand);
                        intK -= cand;
                        K = Long.toString(intK);
                        found = true;
                    }
                }
                if (!found) {
                    K = K.substring(1);
                    if (K.isEmpty()) break;
                    intK = Long.parseLong(K);
                }
            }

            sb.append(res.size()).append("\n");
            for (long i : res) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
