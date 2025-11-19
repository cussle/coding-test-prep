import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        
        for (String phone : phone_book) {
            set.add(phone);
        }
        
        StringBuilder sb;
        boolean answer = true;
        for (String phone : phone_book) {
            int pLen = phone.length();
            sb = new StringBuilder();
            
            for (int i = 0; i < pLen - 1; i++) {
                sb.append(phone.charAt(i));
                
                if (set.contains(sb.toString())) {
                    answer = false;
                    break;
                }
            }
            
            if (!answer) {
                break;
            }
        }
        
        return answer;
    }
}