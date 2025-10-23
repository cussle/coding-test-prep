import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] n = br.readLine().split(" ");
        int target = Integer.parseInt(br.readLine());
        int answer = 0;

        for (String s : n) {
            int temp = Integer.parseInt(s);
            if (temp == target) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}