import static java.lang.Integer.bitCount;
import static java.lang.Long.parseLong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = parseLong(st.nextToken());
        long b = parseLong(st.nextToken());

        if (a == b) {
            System.out.println(0);
            return;
        } else if (a > b) {
            long tmp = a;
            a = b;
            b = tmp;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(b - a - 1).append("\n");
        for (long i = a + 1; i < b; i++) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
