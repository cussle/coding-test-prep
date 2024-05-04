import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();

        int temp;
        boolean isAsc = true, isDesc = true;
        for (int i = 0; i < 8; i++) {
            temp = Integer.parseInt(st.nextToken());
            if (isAsc && (temp != i + 1)) isAsc = false;
            if (isDesc && (temp != 8-i)) isDesc = false;
        }

        if (isAsc) System.out.println("ascending");
        else if (isDesc) System.out.println("descending");
        else System.out.println("mixed");
    }
}
