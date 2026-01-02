import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        StringTokenizer st;
        Map<String, Integer> accTimes = new TreeMap<>();
        
        for (String record : records) {
            st = new StringTokenizer(record);
            int t = timeToInt(st.nextToken());
            String carNum = st.nextToken();
            boolean isOut = st.nextToken().length() == 3;

            if (! isOut) {
                accTimes.put(carNum, accTimes.getOrDefault(carNum, 0) - t);
                continue;
            }

            accTimes.put(carNum, accTimes.get(carNum) + t);
        }
        
        int idx = 0;
        int answer[] = new int[accTimes.size()];
        for (Map.Entry<String, Integer> e : accTimes.entrySet()) {
            int total = e.getValue();
            if (total <= 0) {
                total += (23 * 60 + 59);
            }
            
            int fee = fees[1];
            if (total > fees[0]) {
                fee += ((total - fees[0] + fees[2] - 1) / fees[2]) * fees[3];
            }
            answer[idx++] = fee;
        }

        return answer;
    }
    
    private int timeToInt (String time) {
        int h = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
        int m = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
        return h * 60 + m;
    }
}
