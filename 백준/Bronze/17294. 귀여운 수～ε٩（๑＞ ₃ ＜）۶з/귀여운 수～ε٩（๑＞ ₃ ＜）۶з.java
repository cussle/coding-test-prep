import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputs = br.readLine();

        int length = inputs.length();
        if (length < 3) {
            System.out.println("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
            return;
        }

        int diff = inputs.charAt(0) - inputs.charAt(1);
        for (int i = 2; i < length; i++) {
            if (inputs.charAt(i - 1) - inputs.charAt(i) != diff) {
                System.out.println("흥칫뿡!! <(￣ ﹌ ￣)>");
                return;
            }
        }

        System.out.println("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
    }
}