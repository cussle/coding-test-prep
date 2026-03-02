import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (n --> 0) {
            int days = Integer.parseInt(br.readLine().replace("D-", ""));
            if (days <= 90) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
