import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        boolean[] canRent = new boolean[n + 2];  // 패딩
        
        // 대여할 수 있는지 검토
        for (int r : reserve) {
            boolean isOkay = true;
            for (int l : lost) {
                if (r == l) {
                    isOkay = false;
                    break;
                }
            }
            canRent[r] = isOkay;
        }
        
        // 대여
        for (int l : lost) {
            boolean isDup = false;
            for (int r : reserve) {
                if (r == l) {
                    isDup = true;
                    break;
                }
            }
            
            // 중복될 경우 생략 (자신이 해결하기 때문)
            if (isDup) {
                continue;
            }
            
            if (canRent[l - 1]) {
                canRent[l - 1] = false;
                continue;
            }
            
            if (canRent[l + 1]) {
                canRent[l + 1] = false;
                continue;
            }
            
            n--;
        }
        
        return n;
    }
}