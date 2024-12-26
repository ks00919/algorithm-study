import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        Queue<Integer> maxQueue = new PriorityQueue<>((x, y) -> y - x);
        Queue<Integer> minQueue = new PriorityQueue<>((x, y) -> x - y);

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());

            if (maxQueue.size() > minQueue.size()) {
                minQueue.add(number);
            } else {
                maxQueue.add(number);
            }

            if (!maxQueue.isEmpty() && !minQueue.isEmpty() && maxQueue.peek() > minQueue.peek()) {
                int maxNumber = maxQueue.poll();
                int minNumber = minQueue.poll();

                maxQueue.add(minNumber);
                minQueue.add(maxNumber);
            }
            
            answer.append(maxQueue.peek()).append("\n");
        }

        System.out.print(answer);
    }
}