import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = parseInt(st.nextToken());
		int b = parseInt(st.nextToken());

		int result = gcd(a, b);

		StringBuilder sb = new StringBuilder();
		sb.append(result).append("\n").append(a * b / result);
		System.out.println(sb);
	}

	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}