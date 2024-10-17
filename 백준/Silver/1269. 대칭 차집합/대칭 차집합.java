import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();

        StringTokenizer tokens = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            set.add(Integer.parseInt(tokens.nextToken()));
        }

        tokens = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            int number = Integer.parseInt(tokens.nextToken());

            if (set.contains(number)) {
                set.remove(number);
            } else {
                set.add(number);
            }
        }

        System.out.println(set.size());
    }
}