import java.util.*;

class Solution {
    static final boolean DEBUG = false;
    public int[] solution(int[] fees, String[] records) {
        StringTokenizer st;
        Map<String, Boolean> wasInList = new HashMap<>();
        Map<String, Integer> accTimes = new HashMap<>();
        
        for (String record : records) {
            if (DEBUG) System.out.println(record + "에 대한 처리");
            st = new StringTokenizer(record);
            while (st.hasMoreTokens()) {
                int t = timeToInt(st.nextToken());
                String carNum = st.nextToken();
                boolean isOut = st.nextToken().length() == 3 ? true : false;
                if (DEBUG) System.out.println(" = 변환된 시간: " + t);
                
                if (! isOut) {
                    if (DEBUG) System.out.println(" = 입차");
                    wasInList.put(carNum, true);
                    accTimes.put(carNum, accTimes.getOrDefault(carNum, 0) - t);
                    if (DEBUG) System.out.println(" = 누적 값 변경: " + accTimes.get(carNum));
                    continue;
                }
                
                if (DEBUG) System.out.println(" = 출차");
                wasInList.put(carNum, false);
                accTimes.put(carNum, accTimes.get(carNum) + t);
                if (DEBUG) System.out.println(" = 누적 값 변경: " + accTimes.get(carNum));
            }
            if (DEBUG) System.out.println(" = = = = = \n\n");
        }
        
        List<String> keys = new ArrayList<>(wasInList.keySet());        
        int[] answer = new int[keys.size()];
        Collections.sort(keys);
        
        int idx = 0;
        for (String key : keys) {
            if (wasInList.getOrDefault(key, false)) {
                if (DEBUG) System.out.println(key + "에 대한 추가 처리");
                accTimes.put(key, accTimes.get(key) + (23 * 60 + 59));
                if (DEBUG) System.out.println(" = 누적 값 변경: " + accTimes.get(key));
            }
            
            int curTime = accTimes.getOrDefault(key, 0);
            answer[idx] = fees[1];
            if (curTime > fees[0]) {
                answer[idx] += ((curTime - fees[0] + fees[2] - 1) / fees[2]) * fees[3];
            }
            if (DEBUG) System.out.println(curTime);
            idx++;
        }

        return answer;
    }
    
    private int timeToInt (String time) {
        int h = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
        if (DEBUG) System.out.println(" = = = hour: " + h);
        int m = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
        if (DEBUG) System.out.println(" = = = minute: " + m);
        return h * 60 + m;
    }
}