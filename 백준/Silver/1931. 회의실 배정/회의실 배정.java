import static java.lang.Integer.*;
import java.io.*;
import java.util.*;

public class Main {

    static class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            return this.end - o.end == 0 ? this.start - o.start : this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());

        Time[] schedule = new Time[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i] = new Time(parseInt(st.nextToken()), parseInt(st.nextToken()));
        }
        Arrays.sort(schedule);

        int count = 1;
        Time last = schedule[0];
        for (int i = 1; i < N; i++) {
            if (last.end <= schedule[i].start) {
                count++;
                last = schedule[i];
            }
        }
        System.out.println(count);
    }
}