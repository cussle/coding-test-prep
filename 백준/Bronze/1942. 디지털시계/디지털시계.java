import java.io.*;
import java.util.*;

public class Main {
    private static final int INT_TIME_HOUR = 10_000;
    private static final int INT_TIME_MINUTE = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < 3; t++) {
            st = new StringTokenizer(br.readLine());
            int cur = toIntTime(st.nextToken());
            int end = toIntTime(st.nextToken());
            int cnt = cur % 3 == 0 ? 1 : 0;

            while (cur != end) {
                cur = refineTime(cur + 1);

                if (cur % 3 == 0) {
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int toIntTime(String time) {
        int intTime = 0;
        StringTokenizer st = new StringTokenizer(time, ":");

        intTime += Integer.parseInt(st.nextToken()) * INT_TIME_HOUR;
        intTime += Integer.parseInt(st.nextToken()) * INT_TIME_MINUTE;
        intTime += Integer.parseInt(st.nextToken());

        return intTime;
    }

    private static int refineTime(int time) {
        int hour = time / INT_TIME_HOUR;
        time %= INT_TIME_HOUR;
        int minute = time / INT_TIME_MINUTE;
        time %= INT_TIME_MINUTE;
        int second = time;

        if (second >= 60) {
            second -= 60;
            minute += 1;
        }

        if (minute >= 60) {
            minute -= 60;
            hour += 1;
        }

        if (hour >= 24) {
            hour -= 24;
        }

        return hour * INT_TIME_HOUR + minute * INT_TIME_MINUTE + second;
    }
}
