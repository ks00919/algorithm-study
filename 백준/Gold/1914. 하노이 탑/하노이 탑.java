import static java.lang.Integer.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());

        if (N <= 20) {
            sb.append((int) (Math.pow(2, N) - 1)).append("\n");
            hanoi(N, 1, 2, 3);
        } else {
            BigInteger K = new BigInteger("1");
            for (int i = 0; i < N; i++) {
                K = K.multiply(new BigInteger("2"));
            }
            K = K.subtract(new BigInteger("1"));
            sb.append(K);
        }
        System.out.println(sb);
    }

    public static void hanoi(int n, int start, int mid, int to) {
        if (n == 1) { // 옮길 원반이 한 개(기저조건)
            sb.append(start).append(" ").append(to).append("\n");
            return;
        }

        hanoi(n - 1, start, to, mid);

        sb.append(start).append(" ").append(to).append("\n");

        hanoi(n - 1, mid, start, to);
    }
}