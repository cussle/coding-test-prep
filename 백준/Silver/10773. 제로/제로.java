import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<Integer>();

        for (int i = 0; i < K; i++) {
            int temp = Integer.parseInt(br.readLine());

            if (temp == 0) {
                st.pop();
            }
            else {
                st.push(temp);
            }
        }
        br.close();

        int sum = 0;
        while (! st.empty()) {
            sum += st.pop();
        }

        System.out.println(sum);
    }
}
