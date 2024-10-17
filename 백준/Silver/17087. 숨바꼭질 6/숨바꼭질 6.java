import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = parseInt(st.nextToken());
		int S = parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int answer = distance(S, parseInt(st.nextToken()));
		for (int i = 1; i < N; i++) {
			int distance = distance(S, parseInt(st.nextToken()));
			if (distance == 0)
				continue;
			answer = gcd(answer, distance);
		}

		System.out.println(answer);
	}

	public static int distance(int a, int b) {
		return Math.abs(a - b);
	}

	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}