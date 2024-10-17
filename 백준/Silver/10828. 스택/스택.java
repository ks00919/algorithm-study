import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {

	static int cursor = -1;
	static int[] stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = parseInt(br.readLine());
		stack = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				push(parseInt(st.nextToken()));
				break;
			case "pop":
				sb.append(pop()).append("\n");
				break;
			case "size":
				sb.append(size()).append("\n");
				break;
			case "empty":
				sb.append(empty()).append("\n");
				break;
			default:
				sb.append(top()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}

	static void push(int n) {
		stack[++cursor] = n;
	}

	static int pop() {
		if (cursor == -1)
			return -1;
		return stack[cursor--];
	}

	static int size() {
		return cursor + 1;
	}

	static int empty() {
		return cursor == -1 ? 1 : 0;
	}

	static int top() {
		if (cursor == -1)
			return -1;
		return stack[cursor];
	}
}