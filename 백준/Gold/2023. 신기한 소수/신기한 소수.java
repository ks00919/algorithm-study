import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int depth;
	static StringBuilder number = new StringBuilder();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = parseInt(br.readLine());
		solution(n, 0);
		System.out.println(sb);
	}

	public static void solution(int n, int depth) {
		if (n == depth) {
			if (isPrime(parseInt(number.toString()))) {
				sb.append(number).append('\n');
			}
			number.setLength(depth - 1);
			return;
		}

		for (int i = 1; i <= 9; i++) {
			number.append(i);
			if (!isPrime(parseInt(number.toString()))) {
				number.setLength(depth);
				continue;
			}

			solution(n, depth + 1);
			number.setLength(depth);
		}
	}

	public static boolean isPrime(int number) {
		if (number == 1) {
			return false;
		}
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}