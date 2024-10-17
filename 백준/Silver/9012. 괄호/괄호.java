import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            sb.append(validation(br.readLine().toCharArray()) ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }

    public static boolean validation(char[] array) {
        Stack<Character> s = new Stack<>();

        int size = array.length;

        for (int i = 0; i < size; i++) {
            if (array[i] == '(')
                s.add('(');
            else {
                if (s.isEmpty())
                    return false;
                s.pop();
            }
        }
        return s.isEmpty();
    }
}