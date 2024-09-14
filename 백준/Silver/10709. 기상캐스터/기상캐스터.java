import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] result = new int[h][w];

        for (int i = 0; i < h; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < w; j++) {
                if (chars[j] == 'c') {
                    result[i][j] = 0;
                    continue;
                }

                if (j > 0 && result[i][j - 1] >= 0) {
                    result[i][j] = result[i][j - 1] + 1;
                    continue;
                }

                result[i][j] = -1;
            }
        }

        for (int[] resultWidth : result) {
            for (int resultHeight : resultWidth) {
                sb.append(resultHeight).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
