import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());

        int[][] cost = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = parseInt(st.nextToken());
            }
        }

        int[][] total = new int[N][3];
        for (int i = 0; i < 3; i++) {
            total[0][i] = cost[0][i];
        }

        for (int i = 1; i < N; i++) {
            total[i][0] = (int) Math.min(total[i - 1][1], total[i - 1][2]) + cost[i][0];
            total[i][1] = (int) Math.min(total[i - 1][0], total[i - 1][2]) + cost[i][1];
            total[i][2] = (int) Math.min(total[i - 1][0], total[i - 1][1]) + cost[i][2];
        }

        System.out.println(Math.min(Math.min(total[N - 1][0], total[N - 1][1]), total[N - 1][2]));
    }
}