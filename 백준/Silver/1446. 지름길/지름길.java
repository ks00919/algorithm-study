import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new ArrayList[d + 1];
        for (int i = 0; i <= d; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());

            int to = Integer.parseInt(st.nextToken());
            if (to > d) continue;

            int length = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, length));
        }

        int[] distance = new int[d + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        for (int i = 0; i <= d; i++) {
            if (i > 0) distance[i] = Math.min(distance[i], distance[i - 1] + 1);

            for (Node next : graph[i]) {
                if (distance[next.way] > distance[i] + next.length) {
                    distance[next.way] = distance[i] + next.length;
                }
            }
        }

        System.out.println(distance[d]);
    }

    private static class Node implements Comparable<Node> {
        int way;
        int length;

        public Node(int way, int length) {
            this.way = way;
            this.length = length;
        }


        @Override
        public int compareTo(Node o) {
            return this.length - o.length;
        }
    }
}