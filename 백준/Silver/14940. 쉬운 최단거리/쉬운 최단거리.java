import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;

    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] distances;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        distances = new int[n][m];
        visited = new boolean[n][m];

        Node start = null;

        for (int i = 0; i < n; i++) {
            Arrays.fill(distances[i], -1);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    start = new Node(i, j, 0);
                }

                if (map[i][j] == 0) {
                    distances[i][j] = 0;
                }
            }
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start.x][start.y] = true;

        int[] directionX = {-1, 1, 0, 0};
        int[] directionY = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            distances[curr.x][curr.y] = curr.distance;

            for (int i = 0; i < 4; i++) {
                int dx = curr.x + directionX[i];
                int dy = curr.y + directionY[i];

                if (dx < 0 || dy < 0 || dx >= n || dy >= m || map[dx][dy] == 0 || visited[dx][dy]) continue;
                visited[dx][dy] = true;
                queue.add(new Node(dx, dy, curr.distance + 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(distances[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}