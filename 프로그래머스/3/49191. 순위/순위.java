class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] array = new boolean[n + 1][n + 1];  // 1-index
        
        for (int[] r : results) {
            array[r[0]][r[1]] = true;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    array[i][j] = array[i][j] || (array[i][k] && array[k][j]);
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int temp = 0;
            for (int j = 1; j <= n; j++) {
                if (array[i][j] || array[j][i]) {
                    temp++;
                }
            }
            if (temp == n - 1) {
                answer++;
            }
        }
        return answer;
    }
}