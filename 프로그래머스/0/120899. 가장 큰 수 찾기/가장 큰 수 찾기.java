class Solution {
    public int[] solution(int[] array) {
        int length = array.length;
        int max = 0;
        int idx = -1;
        for (int i = 0; i < length; i++) {
            if (array[i] > max) {
                max = array[i];
                idx = i;
            }
        }
        
        return new int[] {max, idx};
    }
}