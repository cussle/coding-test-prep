import java.io.*;
import java.util.*;

public class Main {
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int month = getMonth(st.nextToken());
        int date = Integer.parseInt(st.nextToken().substring(0, 2));
        int year = Integer.parseInt(st.nextToken());
        int cur = getTime(st.nextToken());
        boolean unique = (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));

        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 1; i < month; i++) {
            if (i == 2 && unique) {
                cur += 1440;
            }
            cur += months[i] * 1440;
        }
        cur += (date - 1) * 1440;

        int div = 1440 * 365;
        if (unique) {
            div += 1440;
        }

        System.out.println((1.0 * cur) / (1.0 * div) * 100);
    }

    private static int getMonth(String month) {
        if (month.equals("January")) {
            return 1;
        }

        if (month.equals("February")) {
            return 2;
        }

        if (month.equals("March")) {
            return 3;
        }

        if (month.equals("April")) {
            return 4;
        }

        if (month.equals("May")) {
            return 5;
        }

        if (month.equals("June")) {
            return 6;
        }

        if (month.equals("July")) {
            return 7;
        }

        if (month.equals("August")) {
            return 8;
        }

        if (month.equals("September")) {
            return 9;
        }

        if (month.equals("October")) {
            return 10;
        }

        if (month.equals("November")) {
            return 11;
        }

        return 12;
    }

    private static int getTime(String time) {
        st = new StringTokenizer(time, ":");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        return hour * 60 + minute;
    }
}