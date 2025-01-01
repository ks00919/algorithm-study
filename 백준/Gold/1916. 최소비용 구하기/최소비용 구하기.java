import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Node>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Node> pq = new PriorityQueue<>();

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.length > distance[curr.to]) continue;

            for (Node next : graph[curr.to]) {
                int dist = next.length + distance[curr.to];

                if (dist < distance[next.to]) {
                    distance[next.to] = dist;
                    pq.add(new Node(next.to, dist));
                }
            }
        }

        System.out.println(distance[end]);
    }

    private static class Node implements Comparable<Node> {
        int to;
        int length;

        public Node(int to, int length) {
            this.to = to;
            this.length = length;
        }

        @Override
        public int compareTo(Node o) {
            return this.length - o.length;
        }
    }
}