import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][] map;

    static class Pair {
        int x, y, key, count;

        public Pair(int x, int y, int key, int count) {
            this.x = x;
            this.y = y;
            this.key = key;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());

        map = new char[N][M];
        Pair curr = null;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);

                if (map[i][j] == '0')
                    curr = new Pair(i, j, 0, 0);
            }
        }

        System.out.println(bfs(curr));
    }

    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static int bfs(Pair start) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(start);
        boolean[][][] visited = new boolean[N][M][64];
        visited[start.x][start.y][0] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            if (map[curr.x][curr.y] == '1')
                return curr.count;

            for (int i = 0; i < 4; i++) {
                int x = curr.x + dx[i];
                int y = curr.y + dy[i];

                if (x < 0 || y < 0 || x >= N || y >= M || map[x][y] == '#' || visited[x][y][curr.key]) {
                    continue;
                }

                visited[x][y][curr.key] = true;
                if (Character.isUpperCase(map[x][y])) {
                    if ((curr.key & (1 << (map[x][y] - 'A'))) == 0) {
                        continue;
                    }
                    q.add(new Pair(x, y, curr.key, curr.count + 1));
                } else if (Character.isLowerCase(map[x][y])) {
                    int key = curr.key | (1 << (map[x][y] - 'A'));
                    q.add(new Pair(x, y, key, curr.count + 1));
                } else {
                    q.add(new Pair(x, y, curr.key, curr.count + 1));
                }
            }
        }

        return -1;
    }
}