import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        LinkedList<Integer> arr = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            arr.addLast(i);
        }

        while (arr.size() > 1) {
            arr.removeFirst();
            arr.addLast(arr.removeFirst());
        }

        System.out.println(arr.get(0));
    }
}
