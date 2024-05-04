import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;

        while (! (str = br.readLine()).equals(".")) {
            boolean stopped = false;
            Stack<Character> st = new Stack<Character>();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '.') break;
                else if (c == '(' || c == '[') st.push(c);
                else if (c == ')') {
                    if (st.empty() || st.peek() != '(') {
                        stopped = true;
                        break;
                    } else st.pop();
                } else if (c == ']') {
                    if (st.empty() || st.peek() != '[') {
                        stopped = true;
                        break;
                    } else st.pop();
                }
            }

            if (stopped || !st.empty()) sb.append("no");
            else sb.append("yes");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
