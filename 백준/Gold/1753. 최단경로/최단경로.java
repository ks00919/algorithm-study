import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = parseInt(st.nextToken());
        int E = parseInt(st.nextToken());

        int K = parseInt(br.readLine());

        List<List<Node>> list = new ArrayList<>(V + 1);

        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = parseInt(st.nextToken());
            int to = parseInt(st.nextToken());
            int weight = parseInt(st.nextToken());

            list.get(from).add(new Node(to, weight));
        }

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(K, 0));

        boolean[] visited = new boolean[V + 1];
        int[] distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K] = 0;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (visited[curr.to])
                continue;

            visited[curr.to] = true;

            for (Node n : list.get(curr.to)) {
                if (distance[n.to] > distance[curr.to] + n.weight)
                    distance[n.to] = distance[curr.to] + n.weight;

                q.add(new Node(n.to, distance[n.to]));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (i == K)
                sb.append(0).append("\n");
            else if (distance[i] == Integer.MAX_VALUE)
                sb.append("INF\n");
            else
                sb.append(distance[i]).append("\n");
        }
        System.out.println(sb);
    }

}