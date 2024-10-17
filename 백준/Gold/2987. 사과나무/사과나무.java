import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Pair[] ground = new Pair[3];
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ground[i] = new Pair(parseInt(st.nextToken()), parseInt(st.nextToken()));
		}

		int N = parseInt(br.readLine());

		double totalArea = area(ground[0], ground[1], ground[2]);
		int count = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = parseInt(st.nextToken());
			int y = parseInt(st.nextToken());

			double sum = 0;
			for (int j = 0; j < 3; j++) {
				if (j == 2) {
					sum += area(x, y, ground[j], ground[0]);
					continue;
				}

				sum += area(x, y, ground[j], ground[j + 1]);
			}

			if (totalArea == sum)
				count++;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(totalArea).append("\n");
		sb.append(count);

		System.out.println(sb);
	}

	public static double area(Pair a, Pair b, Pair c) {
		return area(a.x, a.y, b.x, b.y, c.x, c.y);
	}

	public static double area(int x, int y, Pair a, Pair b) {
		return area(x, y, a.x, a.y, b.x, b.y);
	}

	public static double area(int x1, int y1, int x2, int y2, int x3, int y3) {
		double a = x1 * (y2 - y3);
		double b = x2 * (y3 - y1);
		double c = x3 * (y1 - y2);
		return Math.abs(a + b + c) / 2;
	}
}