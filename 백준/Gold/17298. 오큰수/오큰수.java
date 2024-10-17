import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = parseInt(br.readLine());

        int[] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                numbers[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            numbers[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int n : numbers)
            sb.append(n).append(" ");
        System.out.println(sb.toString());
    }
}