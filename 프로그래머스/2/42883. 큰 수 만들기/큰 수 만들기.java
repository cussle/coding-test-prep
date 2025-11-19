import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        
        int numberLength = number.length();
        for (int i = 0; i < numberLength; i++) {
            int cur = number.charAt(i) - '0';
            
            while (!stack.isEmpty() && stack.peek() < cur && k --> 0) {
                stack.pop();
            }
            
            stack.push(cur);
        }
        
        while (k --> 0) {
            stack.pop();
        }
        
        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.insert(0, stack.pop());
        }
        return answer.toString();
    }
}