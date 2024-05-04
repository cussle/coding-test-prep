import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Integer> queue;

    public static void push(int item) {
        queue.add(item);
    }

    public static int pop() {
        if(queue.isEmpty()) return -1;
        int temp = queue.get(0);
        queue.remove(0);
        return temp;
    }

    public static int size() {
        return queue.size();
    }

    public static int empty() {
        return queue.isEmpty() ? 1 : 0;
    }

    public static int front() {
        if(queue.isEmpty()) return -1;
        return queue.get(0);
    }

    public static int back() {
        if(queue.isEmpty()) return -1;
        return queue.get(queue.size() - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        queue = new ArrayList<Integer>(N);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();

            if (cmd.equals("push")) {
                push(Integer.parseInt(st.nextToken()));
            }
            else if (cmd.equals("pop")) {
                sb.append(pop()).append("\n");
            }
            else if (cmd.equals("size")) {
                sb.append(size()).append("\n");
            }
            else if (cmd.equals("empty")) {
                sb.append(empty()).append("\n");
            }
            else if (cmd.equals("front")) {
                sb.append(front()).append("\n");
            }
            else if (cmd.equals("back")) {
                sb.append(back()).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
