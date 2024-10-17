import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

public class Main {

    static class Location {
        int x, y;
        int breakWall;
        int distance;

        public Location(int x, int y, int breakWall, int distance) {
            this.x = x;
            this.y = y;
            this.breakWall = breakWall;
            this.distance = distance;
        }
    }

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        Queue<Location> q = new ArrayDeque<>();
        q.add(new Location(0, 0, 1, 1));
        boolean[][][] visited = new boolean[N][M][2];

        Location curr = null;
        while (!q.isEmpty()) {
            curr = q.poll();

            if (curr.x == N - 1 && curr.y == M - 1)
                break;

            for (int i = 0; i < 4; i++) {
                int x = curr.x + dx[i];
                int y = curr.y + dy[i];

                if (x < 0 || y < 0 || x >= N || y >= M)
                    continue;

                if (map[x][y] == 1 && curr.breakWall == 0)
                    continue;

                if (map[x][y] == 1 && curr.breakWall == 1) {
                    if (visited[x][y][0])
                        continue;
                    visited[x][y][0] = true;
                    q.add(new Location(x, y, 0, curr.distance + 1));
                } else {
                    if (visited[x][y][curr.breakWall])
                        continue;
                    visited[x][y][curr.breakWall] = true;
                    q.add(new Location(x, y, curr.breakWall, curr.distance + 1));
                }
            }
        }

        if (curr.x != N - 1 || curr.y != M - 1)
            System.out.println(-1);
        else
            System.out.println(curr.distance);
    }

}