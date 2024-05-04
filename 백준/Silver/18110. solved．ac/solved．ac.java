import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<Integer>(N);
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        arr.sort(Comparator.naturalOrder());

        int except = (int) Math.round((double) N * 15 / 100);
        int sum = 0;
        for (int i = except; i < arr.size() - except; i++) {
            sum += arr.get(i);
        }

        System.out.println(Math.round((double) sum / (arr.size() - except * 2)));
        br.close();
    }
}
