import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int[][] arr = new int[15][14];
        for (int i = 0; i < 15; i++) {
            arr[i][0] = 1;
        }
        for (int i = 0; i < 14; i++) {
            arr[0][i] = (i + 1);
        }

        for (int i = 1; i < 15; i++) {  // i층
            for (int j = 1; j < 14; j++) {  // j + 1호
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }

//        for (int i = 0; i < 15; i++) {  // i층
//            for (int j = 0; j < 14; j++) {  // j + 1호
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[k][n-1]).append("\n");
        }
        System.out.println(sb);
    }
}
