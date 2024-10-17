import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = parseInt(st.nextToken());
        int K = parseInt(st.nextToken());
        int L = parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            validate(K, L, parseInt(st.nextToken()), parseInt(st.nextToken()),
                    parseInt(st.nextToken()));
        }

        System.out.println(count);
        System.out.println(sb);
    }

    public static void validate(int K, int L, int... scores) {
        int sum = 0;
        for (int score : scores) {
            if (score < L)
                return;
            sum += score;
        }

        if (sum >= K) {
            count++;
            for (int score : scores)
                sb.append(score).append(" ");
        }
    }
}