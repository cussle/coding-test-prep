import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        int inputLen = input.length();

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < inputLen; i++) {
            char cur = input.charAt(i);
            if (isOperand(cur)) {
                sb.append(cur);
                continue;
            }

            if (cur == '(') {
                stack.offerFirst(cur);
                continue;
            }

            if (cur == ')') {
                while (stack.size() > 0 && stack.peek() != '(') {
                    sb.append(stack.pollFirst());
                }
                stack.pollFirst();
                continue;
            }

            while (stack.size() > 0 && getPrec(stack.peek()) >= getPrec(cur)) {
                sb.append(stack.pollFirst());
            }
            stack.offerFirst(cur);
        }

        while (stack.size() > 0) {
            sb.append(stack.pollFirst());
        }

        System.out.print(sb.toString());
    }

    private static boolean isOperand(char c) {
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }

    private static int getPrec(char c) {
        if (c == '+' || c == '-') {
            return 1;
        }

        if (c == '*' || c == '/') {
            return 2;
        }

        return 0;
    }
}