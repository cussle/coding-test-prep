import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] tracks = new int[26];

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tracks[st.nextToken().charAt(0) - 'A']++;
        }

        System.out.println(tracks[br.readLine().charAt(0) - 'A']);
    }
}