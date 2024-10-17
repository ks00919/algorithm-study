import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		StringBuilder T = new StringBuilder(br.readLine());

		solution(S, T);
	}

	static void solution(String S, StringBuilder T) {
		int cursor = T.length();

		while (--cursor >= 0) {
			if (S.equals(T.toString())) {
				System.out.println(1);
				return;
			}

			if (T.charAt(cursor) == 'B') {
				T.deleteCharAt(cursor);
				T.reverse();
			} else {
				T.deleteCharAt(cursor);
			}

		}

		System.out.println(0);
	}
}