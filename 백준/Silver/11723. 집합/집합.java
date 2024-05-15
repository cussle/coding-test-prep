import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int M = Integer.parseInt(br.readLine());
        int bitSet = 0;

        while (M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int target = 0;
            switch (st.nextToken()) {
                case "add":
                    target = Integer.parseInt(st.nextToken()) - 1;
                    bitSet |= 1 << target;
                    break;
                case "remove":
                    target = Integer.parseInt(st.nextToken()) - 1;
                    bitSet &= ~(1 << target);
                    break;
                case "check":
                    target = Integer.parseInt(st.nextToken()) - 1;
                    int res = bitSet & (1 << target);
                    sb.append((res == 0) ? 0 : 1).append("\n");
                    break;
                case "toggle":
                    target = Integer.parseInt(st.nextToken()) - 1;
                    bitSet ^= 1 << target;
                    break;
                case "all":
                    bitSet = (1 << 21) - 1;
                    break;
                case "empty":
                    bitSet = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}
