import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int target = arr[i];
            int l = 0, r = n - 1;
            
            int cur;
            while (true) {
                if (l == i) {
                    l++;
                } else if (r == i) {
                    r--;
                }

                if (l >= r) {
                    break;
                }
                cur = arr[l] + arr[r];

                if (cur == target) {
                    answer++;
                    // System.out.println(target + " " + arr[l] + " " + arr[r]);
                    break;
                } else if (cur < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        System.out.println(answer);
    }
}