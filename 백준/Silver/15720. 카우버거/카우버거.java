import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int burgerCnt = Integer.parseInt(st.nextToken());
        int sideCnt = Integer.parseInt(st.nextToken());
        int drinkCnt = Integer.parseInt(st.nextToken());
        int maxCnt = Math.max(burgerCnt, Math.max(sideCnt, drinkCnt));

        int[][] products = new int[3][maxCnt];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; st.hasMoreTokens(); j++) {
                products[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(products[i]);
        }

        int[] answer = new int[2];
        for (int j = 0; j < maxCnt; j++) {
            int sum = 0;
            boolean dc = true;
            for (int i = 0; i < 3; i++) {
                sum += products[i][j];
                
                if (products[i][j] == 0) {
                    dc = false;
                }
            }

            answer[0] += sum;
            if (dc) {
                answer[1] += sum * 0.9;
            } else {
                answer[1] += sum;
            }
        }

        System.out.println(answer[0] + "\n" + answer[1]);
    }
}