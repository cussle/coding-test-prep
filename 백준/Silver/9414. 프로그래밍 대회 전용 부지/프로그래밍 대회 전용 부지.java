import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int LIMIT = 5_000_000;
        int T = Integer.parseInt(br.readLine());


        while (T --> 0) {
            LinkedList<Integer> list = new LinkedList<>();
            int temp;
            while ((temp = Integer.parseInt(br.readLine())) != 0) {
                list.add(temp);
            }

            list.sort(Collections.reverseOrder());

            long sum = 0L;
            for (int i = 1; ! list.isEmpty(); i++) {
                sum += (long) (2L * Math.pow(list.pop(), i));
                if (sum > LIMIT) {
                    break;
                }
            }

            if (sum > LIMIT) {
                sb.append("Too expensive");
            } else {
                sb.append(sum);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
