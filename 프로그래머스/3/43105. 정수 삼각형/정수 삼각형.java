class Solution {
    public int solution(int[][] triangle) {
        int depth = triangle.length;
        int dp[][] = new int[depth][];
        
        // 최하층 채우기
        dp[depth - 1] = new int[depth];
        for (int i = 0; i < depth; i++) {
            dp[depth - 1][i] = triangle[depth - 1][i];
        }
        
        // dp 테이블 채우기
        for (int i = depth - 2; i >= 0; i--) {
            dp[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                // System.out.println("i: " + i + ", j: " + j);
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
                dp[i][j] += triangle[i][j];
            }
        }
        
        return dp[0][0];
    }
}
