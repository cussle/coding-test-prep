class Solution {
    public static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(0, numbers, 0, target);
        return answer;
    }
    
    private static void dfs(int current, int[] numbers, int index, int target) {
        if (numbers.length == index) {
            if (target == current) {
                answer++;
            }
            return;
        }
        
        int cur = numbers[index];
        index++;
        
        dfs(current + cur, numbers, index, target);
        dfs(current - cur, numbers, index, target);
    }
}