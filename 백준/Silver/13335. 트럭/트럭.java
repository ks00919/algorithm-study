import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int w = parseInt(st.nextToken());
        int L = parseInt(st.nextToken());

        Queue<Integer> trucks = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks.offer(parseInt(st.nextToken()));
        }

        Queue<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < w; i++) {
            bridge.offer(0);
        }

        int time = 0;
        int weight = 0;
        while (!bridge.isEmpty()) {
            time++;
            weight -= bridge.poll();

            if (trucks.isEmpty())
                continue;

            if (weight + trucks.peek() <= L) {
                weight += trucks.peek();
                bridge.add(trucks.poll());
            } else {
                bridge.add(0);
            }
        }
        System.out.println(time);
    }
}