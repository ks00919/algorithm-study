import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        long[] dp = new long[n + 1];

        int max = Math.min(n, 6);
        for (int i = 0; i <= max; i++) {
            dp[i] = i;
        }

        for (int i = 7; i <= n; i++) {
            for (int j = i - 3; j > 0; j--) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
            }
        }

        System.out.println(dp[n]);
    }
}