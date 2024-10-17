import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    private static int n;
    private static int m;
    private static int[][] map;
    private static boolean[][] visited;

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
    private static int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};

    private static boolean bfs(int x, int y) {
        if (map[x][y] == 0) return false;

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(x, y));

        boolean result = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            visited[cur.x][cur.y] = true;

            if (!check(cur.x, cur.y))
                result = false;

            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) continue;

                if (map[cur.x][cur.y] == map[nx][ny]) {
                    q.add(new Node(nx, ny));
                }
            }
        }
        return result;
    }

    private static boolean check(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

            if (map[x][y] < map[nx][ny]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && bfs(i, j))
                    count++;
            }
        }

        System.out.println(count);
    }
}