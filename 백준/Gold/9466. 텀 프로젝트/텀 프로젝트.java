import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;

    private static int count;
    private static int[] students; // 입력 배열
    private static boolean[] visited; // 방문 체크 배열
    private static boolean[] finished; // 이미 팀이 완성되거나 팀을 이루지 못하는 사람들 체크 배열

    /*
    이 문제의 조건은 2개
    1. 혼자 팀을 이룬 사람을 선택한 사람은 팀이 될 수 없다.
    2. 팀을 이루기 위해서는 서로를 선택해야만 한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());

            count = 0;
            students = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                students[i] = Integer.parseInt(st.nextToken());

                if (i == students[i]) {
                    finished[i] = true;
                    count++;
                }
            }

            for (int i = 1; i <= n; i++) {
                if (finished[i]) continue;
                dfs(i);
            }

            sb.append(n - count).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int number) {
        if (visited[number]) {
            count++;
            finished[number] = true;
        } else {
            visited[number] = true;
        }

        if (!finished[students[number]]) dfs(students[number]);

        visited[number] = false;
        finished[number] = true;
    }
}