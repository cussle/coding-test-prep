import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        int d1 = Integer.parseInt(temp[0]);
        int d2 = Integer.parseInt(temp[1]);
        
        double sub = (d1 - d2) / 2.0;
        System.out.println(k * k - sub * sub);
    }
}