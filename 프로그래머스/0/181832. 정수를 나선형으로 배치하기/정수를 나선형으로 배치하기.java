class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int top = 0;
        int left = 0;
        int right = n - 1;
        int bottom = n - 1;
        int value = 1;
        
        while (value <= n * n) {
            for (int i = left; i <= right; i++) {  // 상단
                answer[top][i] = value++;
            }
            top++;
            
            for (int i = top; i <= bottom; i++) {  // 우측
                answer[i][right] = value++;
            }
            right--;
            
            for (int i = right; i >= left; i--) {  // 하단
                answer[bottom][i] = value++;
            }
            bottom--;
            
            for (int i = bottom; i >= top; i--) {  // 좌측
                answer[i][left] = value++;
            }
            left++;
        }
        
        return answer;
    }
}