import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = parseInt(st.nextToken());
            }
        }

        System.out.println(recursion(N, 0, 0));
    }

    public static int recursion(int size, int x, int y) {
        if (size == 2) {
            return getSecondNumer(size, x, y);
        }

        size /= 2;
        int a = recursion(size, x, y);
        int b = recursion(size, x, y + size);
        int c = recursion(size, x + size, y);
        int d = recursion(size, x + size, y + size);

        return getSecondNumer(a, b, c, d);
    }

    public static int getSecondNumer(int size, int x, int y) {
        List<Integer> list = new ArrayList<>();

        int dx = x + size;
        int dy = y + size;

        for (int i = x; i < dx; i++) {
            for (int j = y; j < dy; j++) {
                list.add(map[i][j]);
            }
        }
        Collections.sort(list);
        return list.get(2);
    }

    public static int getSecondNumer(int... numbers) {
        Arrays.sort(numbers);
        return numbers[2];
    }
}