class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int top = 0, left = 0, right = n - 1, bottom = n - 1;
        int value = 1;

        while (top <= bottom && left <= right) {
            // 상단
            for (int i = left; i <= right; i++) answer[top][i] = value++;
            top++;
            if (top > bottom) break;

            // 우측
            for (int i = top; i <= bottom; i++) answer[i][right] = value++;
            right--;
            if (left > right) break;

            // 하단
            for (int i = right; i >= left; i--) answer[bottom][i] = value++;
            bottom--;
            if (top > bottom) break;

            // 좌측
            for (int i = bottom; i >= top; i--) answer[i][left] = value++;
            left++;
        }
        return answer;
    }
}
