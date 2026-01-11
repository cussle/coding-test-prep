import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputs = br.readLine();
        String bomb = br.readLine();

        int inputsLen = inputs.length();
        int bombLen = bomb.length();

        char[] inputsArr = inputs.toCharArray();
        char[] bombArr = bomb.toCharArray();
        char bombLastChar = bombArr[bombLen - 1];

        char[] stack = new char[inputsLen];
        int size = 0;

        for (int i = 0; i < inputsLen; i++) {
            stack[size] = inputsArr[i];
            size++;

            if (stack[size - 1] == bombLastChar && size >= bombLen) {
                boolean match = true;

                for (int j = 0; j < bombLen; j++) {
                    if (bombArr[j] != stack[size - bombLen + j]) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    size -= bombLen;
                }
            }
        }

        if (size == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(new String(stack, 0, size));
        }
    }
}