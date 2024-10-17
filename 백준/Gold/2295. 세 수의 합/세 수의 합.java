import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = parseInt(br.readLine());
        long max = Long.MIN_VALUE;

        Set<Long> set = new HashSet<>();
        long[] numbers = new long[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = parseLong(br.readLine());
            set.add(numbers[i]);
        }

        for (int x = 0; x < n; x++) {
            for (int y = x; y < n; y++) {
                set.add(numbers[x] + numbers[y]);
            }
        }

        for (int k = 0; k < n; k++) {
            for (int z = 0; z < n; z++) {
                if (set.contains(numbers[k] - numbers[z])) {
                    max = Math.max(max, numbers[k]);
                }
            }
        }

        System.out.println(max);
    }
}
