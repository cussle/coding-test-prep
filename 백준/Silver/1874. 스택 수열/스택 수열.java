import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int index = 1;
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (stack.isEmpty() || stack.peek() < temp) {
                while (stack.isEmpty() || stack.peek() != temp) {
                    stack.push(index++);
                    sb.append("+\n");
                }
            }
            if (stack.peek() == temp) {
                stack.pop();
                sb.append("-\n");
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}
