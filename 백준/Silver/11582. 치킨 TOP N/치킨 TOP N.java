import java.io.*;
import java.util.*;

public class Main {

    private static int n, k;
    private static int[] arr, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(br.readLine());

        arr = new int[n];
        temp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void mergeSort(int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        // Divide
        mergeSort(left, mid);  // left
        mergeSort(mid + 1, right);  // right

        // Merge
        if (n / (right - left + 1) < k) {
            return;
        }
        merge(left, mid, right);
    }

    private static void merge(int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = l;

        while (l <= mid || r <= right) {
            if (r > right) {
                temp[idx++] = arr[l++];
                continue;
            }

            if (l <= mid && arr[l] < arr[r]) {
                temp[idx++] = arr[l++];
                continue;
            }

            temp[idx++] = arr[r++];
        }

        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }
}
