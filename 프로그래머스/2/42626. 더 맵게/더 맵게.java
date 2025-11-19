import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville) {
            pq.add(s);
        }
        
        int cnt = 0;
        int temp;
        while ((temp = pq.poll()) < K) {
            if (pq.isEmpty()) {
                return -1;
            }
            cnt++;
            
            int s = pq.poll();
            temp = temp + s * 2;
            pq.add(temp);
        }
        
        return cnt;
    }
}