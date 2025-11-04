import java.io.*;
import java.util.*;

public class Main {
    static class Prob implements Comparable<Prob> {
        int p;
        int l;

        Prob(int p, int l) {
            this.p = p;
            this.l = l;
        }

        @Override
        public int compareTo(Prob o) {
            if (this.l == o.l) return this.p - o.p;
            return this.l - o.l;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        TreeSet<Prob> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            set.add(new Prob(p, l));
            map.put(p, l);
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                set.add(new Prob(p, l));
                map.put(p, l);
            } 
            else if (cmd.equals("solved")) {
                int p = Integer.parseInt(st.nextToken());
                int l = map.get(p);
                set.remove(new Prob(p, l));
                map.remove(p);
            } 
            else if (cmd.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) sb.append(set.last().p).append("\n");
                else sb.append(set.first().p).append("\n");
            }
        }

        System.out.print(sb);
    }
}
