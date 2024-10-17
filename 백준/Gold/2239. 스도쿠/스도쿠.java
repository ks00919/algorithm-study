import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String input = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        dfs(0, 0);
    }

    public static void dfs(int row, int col) {
        if (col == 9) {
            dfs(row + 1, 0);
            return;
        }

        if (row == 9) {
            printResult();
        }

        if (board[row][col] == 0) {
            for (int i = 1; i < 10; i++) {
                if (check(row, col, i)) {
                    board[row][col] = i;
                    dfs(row, col + 1);
                }
            }
            board[row][col] = 0;
            return;
        }

        dfs(row, col + 1);
    }

    public static boolean check(int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value)
                return false;

            if (board[i][col] == value)
                return false;
        }

        int x = (row / 3) * 3;
        int y = col - col % 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[x + i][y + j] == value)
                    return false;
            }
        }

        return true;
    }

    public static void printResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
        System.exit(0);
    }
}