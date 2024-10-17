import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

public class Main {
	static char[][] board = new char[3][3];
	static int countX, countO;

	static String invalid = "invalid";
	static String valid = "valid";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = null;

		while (!(input = br.readLine()).equals("end")) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					board[i][j] = input.charAt(i * 3 + j);
				}
			}
			countX = 0;
			countO = 0;

			count();
//			System.out.println("count x " + countX + " count o " + countO);

			if (Math.abs(countX - countO) > 1) {
				sb.append(invalid).append("\n");
				continue;
			}

			int successX = checkRow('X');
			int successO = checkRow('O');
//			System.out.println("success x " + successX + "success o " + successO);

			if (successX == 0 && successO == 0) {
				if (countX + countO == 9 && countX > countO)
					sb.append(valid).append("\n");
				else
					sb.append(invalid).append("\n");
			} else {

				if (successX <= 2 && successO == 0 && countX > countO)
					sb.append(valid).append("\n");
				else if (successO < 2 && successX == 0 && countX == countO)
					sb.append(valid).append("\n");
				else
					sb.append(invalid).append("\n");
			}
		}

		System.out.println(sb);
	}

	public static void count() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 'O')
					countO++;
				else if (board[i][j] == 'X')
					countX++;
			}
		}
	}

	public static int checkRow(char player) {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			boolean flag = true;
			for (int j = 0; j < 3; j++) {
				if (player != board[i][j])
					flag = false;
			}
			if (flag)
				count++;

			flag = true;
			for (int j = 0; j < 3; j++) {
				if (player != board[j][i])
					flag = false;
			}
			if (flag)
				count++;
		}

		if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
			count++;
		if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
			count++;

		return count;
	}
}