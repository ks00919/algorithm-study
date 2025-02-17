import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alpha = new int['z' + 1];
        String input = br.readLine();
        int size = input.length();

        Arrays.fill(alpha, -1);
        for (int i = 0; i < size; i++) {
            if (alpha[input.charAt(i)] == -1)
                alpha[input.charAt(i)] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 'a'; i < alpha.length; i++) {
            sb.append(alpha[i]).append(" ");
        }

        System.out.println(sb);
    }
}