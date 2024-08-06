import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        for (int i = 0; i < 6; i++) {
            if (br.readLine().equals("W")) {
                count++;
            }
        }

        int result = -1;

        if (count >= 1) {
            result = 3;
        }

        if (count >= 3) {
            result = 2;
        }

        if (count >= 5) {
            result = 1;
        }

        System.out.println(result);
    }
}
