import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(parseInt(br.readLine()));
		}
		Collections.sort(list);

		StringBuilder sb = new StringBuilder();
		for (int number : list)
			sb.append(number).append("\n");

		System.out.println(sb);
	}
}