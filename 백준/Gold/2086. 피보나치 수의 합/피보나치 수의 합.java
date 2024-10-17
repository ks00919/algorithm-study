import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {

	static int M = 1_000_000_000;

	static Map<Long, Long> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		map.put(0l, 0l);
		map.put(1l, 1l);

		long ap = fibonacci(a + 1);
		long bp = fibonacci(b + 2);

		System.out.println((bp - ap + M) % M);
	}

	public static long fibonacci(long n) {
		if (map.containsKey(n)) {
			return map.get(n);
		}

		if (n % 2 == 0) {
			long index = n / 2;
			long f1 = fibonacci(index - 1);
			long f2 = fibonacci(index);

			long result = (((f1 * 2) + f2) * f2) % M;
			map.put(n, result);
			return result;
		} else {
			long index = (n + 1) / 2;
			long f1 = fibonacci(index);
			long f2 = fibonacci(index - 1);
			long result = ((f1 * f1) + (f2 * f2)) % M;
			map.put(n, result);
			return result;
		}
	}
}