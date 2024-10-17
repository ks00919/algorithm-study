import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] papers;

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

        recursion(N, 0, 0);

        StringBuilder sb = new StringBuilder();
        sb.append(count[0]).append('\n');
        sb.append(count[1]);
        System.out.println(sb);
    }

    static int[] count = new int[2];

    public static void recursion(int size, int startX, int startY) {
        // System.out.println(startX + " " + startY + " " + endX + " " + endY);

        int color = papers[startX][startY];

        if (size == 1) {
            count[color]++;
            return;
        }

        int endX = startX + size;
        int endY = startY + size;

        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {

                if (color != papers[i][j]) {
                    size /= 2;
                    endX = startX + size;
                    endY = startY + size;
                    recursion(size, startX, startY);
                    recursion(size, startX, endY);
                    recursion(size, endX, startY);
                    recursion(size, endX, endY);
                    return;
                }
            }
        }
        count[color]++;
    }

}
