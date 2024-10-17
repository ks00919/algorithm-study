import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int h = parseInt(st.nextToken());
		int m = parseInt(st.nextToken());

		m -= 45;
		if (m < 0) {
			m += 60;
			h -= 1;
		}

		if (h < 0) {
			h += 24;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(h).append(" ").append(m);
		System.out.println(sb);
	}
}