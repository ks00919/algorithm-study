import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int V, E;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = parseInt(st.nextToken());
        E = parseInt(st.nextToken());

        Edge[] list = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int from = parseInt(st.nextToken());
            int to = parseInt(st.nextToken());
            int weight = parseInt(st.nextToken());

            list[i] = new Edge(from, to, weight);
        }
        parents = new int[V + 1];
        Arrays.sort(list);

        int count = 0;
        long weight = 0l;

        for (Edge e : list) {
            if (!union(e.from, e.to))
                continue;

            weight += e.weight;
        }

        System.out.println(weight);
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB)
            return false;

        parents[rootB] = rootA;
        return true;
    }

    static int find(int x) {
        if (parents[x] == x || parents[x] == 0)
            return x;
        return parents[x] = find(parents[x]);
    }

}