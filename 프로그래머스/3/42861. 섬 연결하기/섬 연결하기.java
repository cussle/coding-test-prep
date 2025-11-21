import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        int answer = 0;
        int used = 0;
        for (int[] cost : costs) {
            int to = cost[0];
            int from = cost[1];
            int price = cost[2];
            
            // Union
            if (union(arr, to, from)) {
                answer += price;
                used++;
            }
            
            if (used >= n - 1) {
                break;
            }
            System.out.println(Arrays.toString(cost));
        }
        
        System.out.println(Arrays.toString(arr));
        return answer;
    }
    
    public static int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent, parent[x]);
    }
    
    public static boolean union(int[] parent, int a, int b) {
        int ap = find(parent, a);
        int bp = find(parent, b);
        
        if (ap == bp) {
            return false;
        }
        
        if (ap > bp) {
            parent[ap] = bp;
        } else {
            parent[bp] = ap;
        }
        return true;
    }
}