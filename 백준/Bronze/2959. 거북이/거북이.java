import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        System.out.println(list.get(0) * list.get(2));
    }
}
