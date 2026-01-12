import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        char value;
        Node left, right;
        Node (char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Node[] nodes = new Node[26];
        for (int i = 0; i < 26; i++) {
            nodes[i] = new Node((char) ('A' + i), null, null);
        }

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.charAt(2) != '.') {
                nodes[input.charAt(0) - 'A'].left = nodes[input.charAt(2) - 'A'];
            }
            if (input.charAt(4) != '.') {
                nodes[input.charAt(0) - 'A'].right = nodes[input.charAt(4) - 'A'];
            }
        }

        preOrder(nodes[0]);
        sb.append("\n");
        inOrder(nodes[0]);
        sb.append("\n");
        postOrder(nodes[0]);
        System.out.println(sb.toString());
    }

    private static void preOrder(Node n) {
        sb.append(n.value);

        if (n.left != null) {
            preOrder(n.left);
        }

        if (n.right != null) {
            preOrder(n.right);
        }
    }

    private static void inOrder(Node n) {
        if (n.left != null) {
            inOrder(n.left);
        }

        sb.append(n.value);

        if (n.right != null) {
            inOrder(n.right);
        }
    }

    private static void postOrder(Node n) {
        if (n.left != null) {
            postOrder(n.left);
        }

        if (n.right != null) {
            postOrder(n.right);
        }

        sb.append(n.value);
    }
}