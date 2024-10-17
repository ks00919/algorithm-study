import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            int size = input.length();

            int total = 0;
            int score = 0;

            for (int j = 0; j < size; j++) {
                if (input.charAt(j) == 'X') {
                    score = 0;
                    continue;
                }
                total += ++score;
            }

            sb.append(total).append("\n");
        }

        System.out.println(sb);
    }
}