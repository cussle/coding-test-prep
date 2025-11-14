import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> answer = new ArrayList<>();
        
        for (String intStr : intStrs) {
            int inputNum = Integer.parseInt(intStr.substring(s, s + l));
            
            if (inputNum > k) {
                answer.add(inputNum);
            }
        }
        
        return answer.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}