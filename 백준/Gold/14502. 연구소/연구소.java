import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int max = 0;
    static int[][] map;

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(max);
    }

    public static void dfs(int depth, int x) {
        if (depth == 3) {

            simulate();
            return;
        }

        for (int i = x; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth + 1, i);
                    map[i][j] = 0;
                }
            }
        }
    }

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void simulate() {
        Queue<Pair> q = new ArrayDeque<>();
        int[][] testMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            testMap[i] = Arrays.copyOf(map[i], M);

            for (int j = 0; j < M; j++) {
                if (testMap[i][j] == 2)
                    q.add(new Pair(i, j));
            }
        }

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = curr.x + dx[i];
                int y = curr.y + dy[i];

                if (x < 0 || y < 0 || x >= N || y >= M || testMap[x][y] != 0)
                    continue;

                testMap[x][y] = 2;
                q.add(new Pair(x, y));
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (testMap[i][j] == 0)
                    count++;
            }
        }
        max = max(max, count);
    }
}