import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

public class Main {

    static int R, C, T;

    static int up;
    static int down;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = parseInt(st.nextToken());
        C = parseInt(st.nextToken());
        T = parseInt(st.nextToken());

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = parseInt(st.nextToken());

                if (map[i][j] == -1) {
                    if (up == 0)
                        up = i;
                    else
                        down = i;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            dust();
            purification();
        }

        System.out.println(count());
    }

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void dust() {
        int[][] temp = new int[R][C];
        temp[up][0] = -1;
        temp[down][0] = -1;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    difusion(temp, i, j);
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    temp[i][j] += map[i][j];
                }
            }
        }

        map = temp;
    }

    public static void difusion(int[][] dust, int x, int y) {
        int amount = map[x][y] / 5;
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int difX = x + dx[i];
            int difY = y + dy[i];

            if (difX < 0 || difY < 0 || difX >= R || difY >= C || map[difX][difY] == -1)
                continue;

            dust[difX][difY] += amount;
            count++;
        }

        map[x][y] -= amount * count;
    }

    public static void purification() {
        int x = down + 1;
        int y = 0;

        while (x + 1 < R) {
            map[x][y] = map[++x][y];
        }

        while (y + 1 < C) {
            map[x][y] = map[x][++y];
        }

        while (x > down) {
            map[x][y] = map[--x][y];
        }

        while (y > 1) {
            map[x][y] = map[x][--y];
        }

        map[x][y] = 0;

        x = up - 1;
        y = 0;

        while (x > 0) {
            map[x][y] = map[--x][y];
        }

        while (y + 1 < C) {
            map[x][y] = map[x][++y];
        }

        while (x < up) {
            map[x][y] = map[++x][y];
        }

        while (y > 1) {
            map[x][y] = map[x][--y];
        }

        map[x][y] = 0;
    }

    static long count() {
        long cnt = 0l;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0)
                    cnt += map[i][j];
            }
        }
        return cnt;
    }

}