import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        TreeSet<Integer> S = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            S.add(i);
        }

        int[] ans = new int[n + 1];
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            NavigableSet<Integer> range = S.subSet(a, true, b, true);
            Iterator<Integer> it = range.iterator();
            while (it.hasNext()) {
                int pos = it.next();
                ans[pos] = x;
                it.remove();  // 처리한 요소를 집합에서 바로 제거
            }
        }

        for (int i = 1; i <= n; i++) {
            bw.write(ans[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
