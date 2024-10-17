import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static String s;
    private static boolean[] isCounted = new boolean[26];
    private static int[][] counts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        int q = Integer.parseInt(br.readLine());
        counts = new int[26][s.length()];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int index = a - 'a';

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (!isCounted[index]) {
                isCounted[index] = true;
                init(a);
            }

            sb.append(counts[index][end] - (start == 0 ? 0 : counts[index][start - 1])).append("\n");
        }

        System.out.println(sb);
    }

    private static void init(char a) {
        int index = a - 'a';
        int length = s.length();

        counts[index][0] = s.charAt(0) == a ? 1 : 0;
        for (int i = 1; i < length; i++) {
            counts[index][i] = s.charAt(i) == a ? counts[index][i - 1] + 1 : counts[index][i - 1];
        }
    }
}
