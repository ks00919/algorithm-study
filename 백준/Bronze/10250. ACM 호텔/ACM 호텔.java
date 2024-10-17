import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int H = parseInt(st.nextToken());
            int W = parseInt(st.nextToken());
            int N = parseInt(st.nextToken());

            int floor = N % H;
            int room = 0;

            if (floor == 0) {
                floor = H * 100;
                room = N / H;
            } else {
                floor *= 100;
                room = N / H + 1;
            }
            sb.append(floor + room).append("\n");
        }

        System.out.println(sb);
    }
}