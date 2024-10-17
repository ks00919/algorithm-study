import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		int[] players = new int[1001];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int length = parseInt(st.nextToken());
			if (players[length] == 2)
				continue;
			players[length]++;
		}

		int sum = 0;
		for (int count : players) {
			sum += count;
		}
		System.out.println(sum);
	}

}