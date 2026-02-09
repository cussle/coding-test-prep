import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] board = new int[c][r];

        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < r; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = c - 1; j >= 0; j--) {
                if (board[j][i] != Integer.parseInt(st.nextToken())) {
                    printFail();
                    return;
                }
            }
        }

        printSuccess();
    }

    private static void printFail() {
        System.out.println(new StringBuilder()
                                .append("|>___/|     /}\n")
                                .append("| O O |    / }\n")
                                .append("( =0= )\"\"\"\"  \\\n")
                                .append("| ^  ____    |\n")
                                .append("|_|_/    ||__|"));
    }

    private static void printSuccess() {
        System.out.println(new StringBuilder()
                                .append("|>___/|        /}\n")
                                .append("| O < |       / }\n")
                                .append("(==0==)------/ }\n")
                                .append("| ^  _____    |\n")
                                .append("|_|_/     ||__|"));
    }
}