import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = new int[10];
        for (int i = 0; i < 5; i++) {
            inputs[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 0; i < 10; i++) {
            if (inputs[i] % 2 != 0) {
                System.out.println(i);
            }
        }
    }
}
