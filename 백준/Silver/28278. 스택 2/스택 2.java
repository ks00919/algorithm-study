import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

public class Main {

	static int[] stack;
	static int cursor;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = parseInt(br.readLine());
		stack = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int order = parseInt(st.nextToken());
			switch (order) {
			case 1:
				push(parseInt(st.nextToken()));
				break;
			case 2:
				sb.append(pop()).append("\n");
				break;
			case 3:
				sb.append(size()).append("\n");
				break;
			case 4:
				sb.append(isEmpty()).append("\n");
				break;
			case 5:
				sb.append(peek()).append("\n");
			}
		}
		System.out.println(sb);
	}

	public static void push(int x) {
		stack[cursor++] = x;
	}

	public static int pop() {
		if (cursor == 0)
			return -1;
		return stack[--cursor];
	}

	public static int isEmpty() {
		if (cursor == 0)
			return 1;
		return 0;
	}

	public static int size() {
		return cursor;
	}

	public static int peek() {
		if (cursor == 0)
			return -1;
		return stack[cursor - 1];
	}
}