import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int[] dwarves = new int[9];

    public static int[] answer = new int[7];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            dwarves[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(dwarves);

        dfs(8, 6, 0);
    }

    public static void dfs(int index, int depth, int sum) {
        if (depth < 0) {
            if (sum != 100)
                return;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 7; i++) {
                sb.append(answer[i]).append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (sum > 100 || index < 0)
            return;

        dfs(index - 1, depth, sum);
        answer[depth] = dwarves[index];
        dfs(index - 1, depth - 1, sum + dwarves[index]);
    }
}