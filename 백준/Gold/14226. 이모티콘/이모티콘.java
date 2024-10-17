import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

import static java.lang.Integer.parseInt;

public class Main {

    private static class Emoji {
        int time;
        int count;
        int board;

        public Emoji(int time, int count, int board) {
            this.time = time;
            this.count = count;
            this.board = board;
        }
    }

    private static int bfs(int s) {
        Queue<Emoji> queue = new ArrayDeque<>();
        queue.add(new Emoji(0, 1, 0));

        boolean[][] visited = new boolean[1001][1001];

        while (!queue.isEmpty()) {
            Emoji curr = queue.poll();

            visited[curr.count][curr.board] = true;

            if (curr.count == s)
                return curr.time;

            int time = curr.time + 1;
            if (!visited[curr.count][curr.count])
                queue.add(new Emoji(time, curr.count, curr.count));


            int count = curr.count + curr.board;
            if (count < visited.length && !visited[count][curr.board])
                queue.add(new Emoji(time, count, curr.board));


            count = curr.count - 1;
            if (count > 0 && !visited[count][curr.board])
                queue.add(new Emoji(time, count, curr.board));
        }
        return -1;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = parseInt(br.readLine());
        System.out.println(bfs(s));
    }
}