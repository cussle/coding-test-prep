import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int length = words.length;
        int[] answer = new int[2];
        Set<String> logs = new HashSet<>();
        
        int i = 0;
        String cur = words[i];
        for (i = 1; i < length; i++) {
            logs.add(cur);
            char prev = cur.charAt(cur.length() - 1);
            cur = words[i];
            
            if (prev != cur.charAt(0)) {
                break;
            }
            
            if (logs.contains(cur)) {
                break;
            }
        }
        
        if (i != length) {
            i++;
            System.out.println(i);
            answer[0] = i % n == 0 ? n : i % n;
            answer[1] = i % n == 0 ? i / n : i / n + 1;
        }

        return answer;
    }
}