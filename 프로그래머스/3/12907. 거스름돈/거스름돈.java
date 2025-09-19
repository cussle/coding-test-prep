import java.util.*;

class Solution {
    // 재귀; 시간 초과
//     public int solution(int n, int[] money) {
//         Arrays.sort(money);
//         return calc(n, money, money.length - 1);
//     }
    
//     public int calc(int number, int[] money, int index) {
//         if (number == 0) {
//             return 1;
//         }
        
//         if (number < 0 || index < 0) {
//             return 0;
//         }
        
//         int target = money[index];
//         int count = 0;
        
//         for (int i = 0; target * i <= number; i++) {
//             count += calc(number - target * i, money, index - 1);
//         }
        
//         return count;
//     }
    
    // 메모이제이션
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1;  // 0원 만드는 경우의 수: 1개
        
        for (int m : money) {
            for (int i = m; i <= n; i++) {
                dp[i] += dp[i - m];
            }
        }
        
        return dp[n];
    }
}