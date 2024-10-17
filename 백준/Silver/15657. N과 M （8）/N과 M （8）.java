import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] numbers;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());

        numbers = new int[N];
        selected = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        dfs(0, 0);
        System.out.println(sb);
    }

    public static void dfs(int depth, int lastIndex) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = lastIndex; i < N; i++) {
            selected[depth] = numbers[i];
            dfs(depth + 1, i);
        }
    }

}