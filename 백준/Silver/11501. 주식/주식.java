import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            long[] money = new long[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                money[i] = Long.parseLong(st.nextToken());
            }

            long sum = 0;
            long max = money[n - 1];

            for (int i = n - 2; i >= 0; i--) {
                if (money[i] > max) {
                    max = money[i];
                    continue;
                }

                sum += max - money[i];
            }

            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}