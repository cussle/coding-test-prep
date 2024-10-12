import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();
//        System.out.println(N);

        String binary = Integer.toBinaryString(N);
        StringBuilder reverse = new StringBuilder();

//        System.out.println(binary);
        for (int i = 0; i < binary.length(); i++) {
            reverse.insert(0, binary.charAt(i));
        }

//        System.out.println(reverse);
        int result = Integer.parseInt(reverse.toString(), 2);
        System.out.println(result);
    }
}
