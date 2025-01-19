import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int n;
    private static char[][] array;
    private static boolean answer;
    private static List<Pair> teachers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        array = new char[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine().replaceAll(" ", "");
            for (int j = 0; j < n; j++) {
                array[i][j] = input.charAt(j);

                if (array[i][j] == 'T')
                    teachers.add(new Pair(i, j));
            }
        }

        dfs(0, 0, 0);
        System.out.println(answer ? "YES" : "NO");
    }

    private static void dfs(int depth, int x, int y) {
        if (depth == 3) {
            validate();
            return;
        }

        if (answer)
            return;

        for (int i = x; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] != 'X')
                    continue;
                array[i][j] = 'O';
                dfs(depth + 1, i, j + 1);
                array[i][j] = 'X';
            }
        }
    }

    private static int[] directionX = {-1, 1, 0, 0};
    private static int[] directionY = {0, 0, -1, 1};

    private static void validate() {
        for (Pair teacher : teachers) {
            for (int i = 0; i < 4; i++) {

                int dx = teacher.x + directionX[i];
                int dy = teacher.y + directionY[i];

                while (dx >= 0 && dx < n && dy >= 0 && dy < n) {

                    if (array[dx][dy] == 'O')
                        break;

                    if (array[dx][dy] == 'S')
                        return;

                    dx += directionX[i];
                    dy += directionY[i];
                }

            }
        }

        answer = true;
    }

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "x : " + x + " y : " + y;
        }
    }

}