import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int modeMax = 0;
        List<Integer> modeCandidates = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            arr[i] = temp;
            sum += temp;
            if (min > temp) min = temp;
            if (max < temp) max = temp;

            int freq = map.getOrDefault(temp, 0) + 1;
            map.put(temp, freq);
            if (freq > modeMax) {
                modeMax = freq;
                modeCandidates.clear();
                modeCandidates.add(temp);
            } else if (freq == modeMax) {
                modeCandidates.add(temp);
            }
        }
        Arrays.sort(arr);
        Collections.sort(modeCandidates);

        sb.append(Math.round((double) sum / N)).append("\n");
        sb.append(arr[N / 2]).append("\n");
        sb.append(modeCandidates.size() > 1 ? modeCandidates.get(1) : modeCandidates.get(0)).append("\n");
        sb.append(max - min).append("\n");

        System.out.println(sb);
    }
}
