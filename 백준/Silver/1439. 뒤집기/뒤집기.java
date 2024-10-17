import static java.lang.Integer.*;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int count = 0;
		for (int i = 0; i < input.length() - 1; i++) {
			if (input.charAt(i) != input.charAt(i + 1)) {
				count++;
			}
		}
		System.out.println((count + 1) / 2);
	}
}