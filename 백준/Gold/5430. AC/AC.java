import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String tempArr = br.readLine();
            String[] arr = tempArr.length() > 2 ? tempArr.substring(1, tempArr.length() - 1).split(",") : new String[0];

            boolean isErr = false;
            boolean reverse = false;
            int start = 0, end = n - 1;

            for (int i = 0; i < p.length(); i++) {
                char cmd = p.charAt(i);

                if (cmd == 'R') {
                    reverse = !reverse;
                } else if (cmd == 'D') {
                    if (start > end || (start == end && arr[start].equals(""))) {
                        isErr = true;
                        break;
                    }
                    if (reverse) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }

            if (isErr) {
                sb.append("error");
            } else {
                sb.append("[");
                if (reverse) {
                    for (int i = end; i >= start; i--) {
                        sb.append(arr[i]);
                        if (i != start) sb.append(",");
                    }
                } else {
                    for (int i = start; i <= end; i++) {
                        sb.append(arr[i]);
                        if (i != end) sb.append(",");
                    }
                }
                sb.append("]");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
