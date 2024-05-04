import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            int vps = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') vps++;
                else if (str.charAt(j) == ')') vps--;
                
                if(vps < 0) break;
            }
//            System.out.println("[DEBUG] vps: " + vps);
            if (vps == 0) System.out.println("YES");
            else System.out.println("NO");
        }
        br.close();
    }
}
