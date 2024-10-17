import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());
        int K = parseInt(st.nextToken());

        int[] W = new int[N + 1];
        int[] V = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = parseInt(st.nextToken());
            V[i] = parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                if (i - W[j] >= 0) {
                    dp[j][i] = Math.max(dp[j - 1][i], dp[j - 1][i - W[j]] + V[j]);
                } else {
                    dp[j][i] = dp[j - 1][i];
                }
            }
        }

        System.out.println(dp[N][K]);
    }

}