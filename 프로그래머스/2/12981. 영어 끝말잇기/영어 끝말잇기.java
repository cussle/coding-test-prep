import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int length = words.length;
        Set<String> logs = new HashSet<>();
        
        logs.add(words[0]);
        for (int i = 1; i < length; i++) {
            String prev = words[i - 1];
            String cur = words[i];
            
            boolean wrongWord = prev.charAt(prev.length() - 1) != cur.charAt(0);
            boolean duplicated = logs.contains(cur);
            
            if (wrongWord || duplicated) {
                int person = i % n + 1;
                int turn = i / n + 1;
                return new int[]{person, turn};
            }
            
            logs.add(cur);
        }
        
        return new int[]{0, 0};
    }
}