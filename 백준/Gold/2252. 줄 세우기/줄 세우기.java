import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int value;
        List<Integer> list;

        public Node(int value) {
            this.value = value;
            list = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());

        if (N == 1) {
            System.out.println(1);
            System.exit(0);
        }

        Node[] students = new Node[N + 1];
        int[] indegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int left = parseInt(st.nextToken());
            int right = parseInt(st.nextToken());

            if (students[left] == null) {
                students[left] = new Node(left);
            }

            students[left].list.add(right);
            indegree[right]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int node = q.poll();
            sb.append(node).append(" ");

            if (students[node] == null)
                continue;

            for (int number : students[node].list) {
                if (--indegree[number] == 0) {
                    if (students[number] == null) {
                        sb.append(number).append(" ");
                        continue;
                    }
                    q.add(number);
                }
            }
        }

        System.out.println(sb);
    }

}