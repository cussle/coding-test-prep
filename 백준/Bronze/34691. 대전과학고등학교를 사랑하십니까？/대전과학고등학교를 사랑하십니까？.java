import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;

        while (!(input = br.readLine()).equals("end")) {
            if (input.equals("animal")) {
                sb.append("Panthera tigris\n");
            } else if (input.equals("tree")) {
                sb.append("Pinus densiflora\n");
            } else if (input.equals("flower")) {
                sb.append("Forsythia koreana\n");
            }
        }
        
        System.out.println(sb.toString());
    }
}