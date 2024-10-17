import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] gears;
    static int[][] index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        gears = new int[4][8];
        index = new int[4][3];

        for (int i = 0; i < 4; i++) {
            String input = br.readLine();

            for (int j = 0; j < 8; j++) {
                gears[i][j] = input.charAt(j) - '0';
            }

            index[i][0] = 0;
            index[i][1] = 2;
            index[i][2] = 6;
        }

        int K = parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rotate(parseInt(st.nextToken()) - 1, parseInt(st.nextToken()));
        }

        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i][index[i][0]] == 1)
                score += Math.pow(2, i);
        }
        System.out.println(score);
    }

    public static void rotate(int gearNumber, int direction) {
        int[][] change = new int[4][4];
        for (int i = 0; i < 4; i++) {
            change[i] = Arrays.copyOf(index[i], 4);
        }

        direction *= -1;
        int tmp = direction;
        for (int i = 0; i < 3; i++) {
            change[gearNumber][i] = getIndex(index[gearNumber][i], direction);
        }

        int number = gearNumber;
        while (number > 0) {
            if (gears[number][index[number][2]] == gears[--number][index[number][1]])
                break;

            direction *= -1;
            for (int i = 0; i < 3; i++) {
                change[number][i] = getIndex(index[number][i], direction);
            }
        }

        direction = tmp;
        number = gearNumber;
        while (number + 1 < 4) {
            if (gears[number][index[number][1]] == gears[++number][index[number][2]])
                break;

            direction *= -1;
            for (int i = 0; i < 3; i++) {
                change[number][i] = getIndex(index[number][i], direction);
            }
        }

        index = change;
    }

    public static int getIndex(int x, int direction) {
        int dx = x + direction;
        if (dx >= 8)
            return dx - 8;
        else if (dx < 0)
            return dx + 8;
        return dx;
    }
}