import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public interface Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> nMap = new HashSet<>();
        for (int i = 0; i < N; i++) {
            nMap.add(br.readLine());
        }

        HashSet<String> mMap = new HashSet<>();
        for (int i = 0; i < M; i++) {
            mMap.add(br.readLine());
        }

        nMap.retainAll(mMap);
        ArrayList<String> results = new ArrayList<>(nMap);
        Collections.sort(results);

        int count = nMap.size();
        sb.append(count).append("\n");
        for (int i = 0; i < count; i++) {
            sb.append(results.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}
