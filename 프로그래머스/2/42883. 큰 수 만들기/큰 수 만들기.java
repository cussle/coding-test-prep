import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        
        int numberLength = number.length();
        for (int i = 0; i < numberLength; i++) {
            int cur = number.charAt(i) - '0';
            
            while (!stack.isEmpty() && k > 0 && stack.peek() < cur) {
                stack.pop();
                k--;
            }
            
            stack.push(cur);
        }
        
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.insert(0, stack.pop());
        }
        return answer.toString();
    }
}