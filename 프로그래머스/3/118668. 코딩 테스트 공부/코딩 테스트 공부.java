class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        // 필요한 알고력, 코딩력 계산
        int reqAlp = 0;
        int reqCop = 0;
        for (int[] p : problems) {
            reqAlp = Math.max(reqAlp, p[0]);
            reqCop = Math.max(reqCop, p[1]);
        }
        
        // dp 범위 조정
        alp = Math.min(reqAlp, alp);
        cop = Math.min(reqCop, cop);
        
        // dp 테이블 초기화
        int[][] dp = new int[reqAlp + 2][reqCop + 2];
        for (int i = 0; i < reqAlp + 2; i++) {
            for (int j = 0; j < reqCop + 2; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[alp][cop] = 0;
        
        // dp 계산
        for (int i = alp; i < reqAlp + 1; i++) {
            for (int j = cop; j < reqCop + 1; j++) {
                // 알고력 공부
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                
                // 코딩력 공부
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                
                // 문제 풀이
                for (int[] p : problems) {
                    if (p[0] <= i && p[1] <= j) {
                        int nextAlp = Math.min(reqAlp, i + p[2]);
                        int nextCop = Math.min(reqCop, j + p[3]);
                        
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + p[4]);
                    }
                }
            }
        }
        
        return dp[reqAlp][reqCop];
    }
}
