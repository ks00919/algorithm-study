import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		int[] ropes = new int[N];

		for (int i = 0; i < N; i++) {
			ropes[i] = parseInt(br.readLine());
		}
		Arrays.sort(ropes);

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, ropes[i] * (N - i));
		}
		System.out.println(max);
	}
}