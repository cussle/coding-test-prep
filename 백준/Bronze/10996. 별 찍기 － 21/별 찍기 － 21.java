import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[] stars = {'*', ' '};
        for (int i = 0; i < n * 2; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(stars[(i + j) % 2]);
            }
            System.out.println();
        }
    }
}