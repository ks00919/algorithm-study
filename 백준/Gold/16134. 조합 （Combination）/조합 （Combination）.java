import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {

	static int P = 1_000_000_007;
	static long[] factorial = new long[100_0001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = parseInt(st.nextToken());
		int R = parseInt(st.nextToken());

		factorial[0] = 1;
		for (int i = 1; i <= 100_0000; i++) {
			factorial[i] = (factorial[i - 1] * i) % P;
		}

		long result = (factorial[N] * pow((factorial[R] * factorial[N - R] % P), P - 2)) % P;
		System.out.println(result);
	}

	public static long pow(long a, long p) {
		if (p == 0)
			return 1;

		long result = (pow(a, p / 2));
		long next = (result * result) % P;
		return p % 2 == 0 ? next : (next * a) % P;
	}

}