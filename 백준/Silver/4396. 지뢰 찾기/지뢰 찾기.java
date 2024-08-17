import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        char[][] result = new char[n][n];
        boolean isFail = false;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                if (input.charAt(j) == 'x') {
                    if (board[i][j] == '*') {
                        isFail = true;
                    } else {
                        int bombCount = 0;
                        for (int k = 0; k < 8; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == '*') {
                                bombCount++;
                            }
                        }
                        result[i][j] = Character.forDigit(bombCount, 10);
                    }
                } else {
                    result[i][j] = '.';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isFail && board[i][j] == '*') {
                    System.out.print('*');
                } else {
                    System.out.print(result[i][j]);
                }
            }
            System.out.println();
        }
    }
}
