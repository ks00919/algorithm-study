import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] map;

    static Fish shark;
    static int eatCount;

    static class Fish implements Comparable<Fish> {
        int x, y, size;

        public Fish(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }

        @Override
        public int compareTo(Fish o) {
            if (this.size != o.size) {
                return this.size - o.size;
            }
            return this.x == o.x ? this.y - o.y : this.x - o.x;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    shark = new Fish(i, j, 2);
                    map[i][j] = 0;
                }
            }
        }

        int time = 0;
        int move = 0;

        while ((move = bfs()) != 0) {
            time += move;
        }

        System.out.println(time);
    }

    static int[] dx = { -1, 0, 0, 1 };
    static int[] dy = { 0, -1, 1, 0 };

    public static int bfs() {

        boolean[][] visited = new boolean[N][N];
        Queue<Fish> q = new ArrayDeque<>();
        Queue<Fish> pq = new PriorityQueue<>();

        q.add(new Fish(shark.x, shark.y, 0));
        visited[shark.x][shark.y] = true;

        while (!q.isEmpty()) {
            Fish location = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = location.x + dx[i];
                int y = location.y + dy[i];

                if (x < 0 || y < 0 || x >= N || y >= N || visited[x][y])
                    continue;

                if (map[x][y] > shark.size)
                    continue;
                visited[x][y] = true;

                if (map[x][y] != 0 && map[x][y] < shark.size) {
                    pq.add(new Fish(x, y, location.size + 1));
                }

                q.add(new Fish(x, y, location.size + 1));
            }
        }

        if (pq.isEmpty())
            return 0;

        Fish fish = pq.poll();

        shark.x = fish.x;
        shark.y = fish.y;

        map[fish.x][fish.y] = 0;
        if (++eatCount == shark.size) {
            eatCount = 0;
            shark.size++;
        }

        return fish.size;
    }

}
