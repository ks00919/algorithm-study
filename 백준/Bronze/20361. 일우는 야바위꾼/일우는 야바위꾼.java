import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = parseInt(st.nextToken());
		int X = parseInt(st.nextToken());
		int K = parseInt(st.nextToken());

		int[] cups = new int[N + 1];
		cups[X] = 1;

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = parseInt(st.nextToken());
			int b = parseInt(st.nextToken());

			int tmp = cups[a];
			cups[a] = cups[b];
			cups[b] = tmp;
		}

		for (int i = 1; i <= N; i++) {
			if (cups[i] == 1) {
				System.out.println(i);
				break;
			}

		}
	}
}
