import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] factArr = {1, 2, 6, 24, 120};

        String input = null;
        while (!(input = br.readLine()).equals("0")) {
            int result = 0;
            int length = input.length();

            for (int i = 0; i < length; i++) {
                char charAtI = input.charAt(length - i - 1);
                result += Character.getNumericValue(charAtI) * factArr[i];
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
