import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;

    private static int[] dirX = {-1, 1, 0, 0};
    private static int[] dirY = {0, 0, -1, 1};

    private static int[][] map;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    count++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    public static void bfs(int x, int y) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(x, y));
        map[x][y] = -1;
        int count = 0;

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int dx = curr.x + dirX[i];
                int dy = curr.y + dirY[i];

                if (dx < 0 || dy < 0 || dx >= n || dy >= m || map[dx][dy] != 1)
                    continue;

                map[dx][dy] = -1;
                queue.add(new Pair(dx, dy));
            }

        }

        max = Math.max(count, max);
    }

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}