import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {

    public static class Student {
        int wish;
        int number;

        public Student(int number, int wish) {
            this.number = number;
            this.wish = wish;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Student> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            q.add(new Student(i, parseInt(st.nextToken())));
        }

        int time = 0;
        int[] total = new int[N];

        while (!q.isEmpty()) {
            Student curr = q.poll();
            time++;

            if (--curr.wish == 0) {
                total[curr.number] = time;
                continue;
            }

            q.add(curr);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(total[i]).append(" ");
        }
        System.out.println(sb);
    }
}