import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());

        for (int i = 0; i < repeat; i++) {
            String str = br.readLine();
            int sum = 0, cont = 1;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'O') {
                    sum += cont;
                    cont ++;
                } else {
                    cont = 1;
                }
            }
            System.out.println(sum);
        }
    }
}
