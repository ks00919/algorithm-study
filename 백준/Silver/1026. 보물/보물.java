import static java.lang.Integer.*;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];

		StringTokenizer a = new StringTokenizer(br.readLine());
		StringTokenizer b = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = parseInt(a.nextToken());
			B[i] = parseInt(b.nextToken());
		}

		Arrays.sort(A);
		Arrays.sort(B);

		int sum = 0;
		int index = N - 1;
		for (int i = 0; i < N; i++) {
			sum += A[i] * B[index--];
		}

		System.out.println(sum);
	}
}