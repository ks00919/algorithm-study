import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = parseInt(st.nextToken()); // 회전 초밥 벨트에 놓인 접시의 수
        int d = parseInt(st.nextToken()); // 초밥의 가짓수
        int k = parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        int c = parseInt(st.nextToken()); // 쿠폰 번호 c

        int[] belt = new int[N];
        int[] sushi = new int[d + 1];
        for (int i = 0; i < N; i++) {
            belt[i] = parseInt(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < k; i++) {
            if (sushi[belt[i]]++ == 0)
                count++;
        }

        int max = sushi[c] == 0 ? count + 1 : count;

        for (int i = 1; i < N; i++) {
            if (--sushi[belt[i - 1]] == 0)
                count--;

            int end = (i + k - 1) % N;

            if (sushi[belt[end]]++ == 0)
                count++;

            if (sushi[c] == 0)
                max = Math.max(max, count + 1);
            else
                max = Math.max(max, count);
        }

        System.out.println(max);
    }

}