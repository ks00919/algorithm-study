import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] papers;
    static int[] count = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        papers = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                papers[i][j] = parseInt(st.nextToken());
            }
        }

        resize(N, 0, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(count[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void resize(int size, int x, int y) {
        int number = papers[x][y];

        if(check(size, x, y)) {
            count[number + 1]++;
        }else {
            size /= 3;

            for (int k = 0; k < 3; k++) {
                resize(size, x, y);
                resize(size, x, y + size);
                resize(size, x, y + size * 2);
                x += size;
            }
        }
    }

    public static boolean check(int size, int x, int y) {
        if (size == 1) {
            return true;
        }

        int number = papers[x][y];

        int dx = x + size;
        int dy = y + size;

        for (int i = x; i < dx; i++) {
            for (int j = y; j < dy; j++) {
                if (number != papers[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
