import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        String inputs;
        while (!(inputs = br.readLine()).equals("0 0 0")) {
            st = new StringTokenizer(inputs);

            double m = Double.parseDouble(st.nextToken()) * 3600.0;
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            long diff = Math.abs(Math.round(m * (1.0 / a - 1.0 / b)));

            beautifySec(diff);
        }

        System.out.println(sb.toString());
    }

    private static void beautifySec(long sec) {
        long h = sec / 3600;
        sec %= 3600;
        sb.append(h).append(":");

        long m = sec / 60;
        sec %= 60;
        if (m < 10) {
            sb.append("0");
        }
        sb.append(m).append(":");

        if (sec < 10) {
            sb.append("0");
        }
        sb.append(sec);

        sb.append("\n");
    }
}