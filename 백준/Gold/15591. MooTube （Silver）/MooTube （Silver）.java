import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n;
    private static int q;

    private static List<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int usado = Integer.parseInt(st.nextToken());

            graph[to].add(new Edge(from, usado));
            graph[from].add(new Edge(to, usado));
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            int videoIndex = Integer.parseInt(st.nextToken());

            answer.append(ask(k, videoIndex)).append(("\n"));
        }
        System.out.println(answer);
    }

    private static int ask(int k, int videoIndex) {
        Queue<Edge> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        int count = 0;

        queue.add(new Edge(videoIndex, Integer.MAX_VALUE));
        visited[videoIndex] = true;

        while (!queue.isEmpty()) {
            Edge current = queue.poll();

            for (Edge next : graph[current.to]) {
                if (visited[next.to] || next.usado < k) continue;

                queue.add(new Edge(next.to, Math.min(current.usado, next.usado)));
                visited[next.to] = true;
                count++;
            }
        }

        return count;


    }

    private static class Edge {
        int to;
        int usado;

        public Edge(int to, int usado) {
            this.to = to;
            this.usado = usado;
        }
    }
}