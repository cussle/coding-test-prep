import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        StringBuilder result = new StringBuilder();

        int length = n.length();
        for (int i = 1; i <= length; i++) {
            result.insert(0, n.charAt(length - i));
            if (i % 3 == 0 && i != length) {
                result.insert(0, ',');
            }
        }

        System.out.println(result.toString());
    }
}
