import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {

    static String success = "happy";
    static String fail = "sad";
    static int INF = 9999999;

    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = parseInt(br.readLine());
            Location[] locations = new Location[n + 2];

            for (int i = 0; i < locations.length; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                locations[i] = new Location(parseInt(st.nextToken()), parseInt(st.nextToken()));
            }

            int[][] fluid = new int[n + 2][n + 2];

            for (int i = 0; i < fluid.length; i++) {
                for (int j = 0; j < fluid.length; j++) {
                    if (i == j) {
                        fluid[i][j] = INF;
                        continue;
                    }

                    int beers = beersOf(locations[i], locations[j]);
                    fluid[i][j] = beers > 20 ? INF : beers;
                }
            }

            for (int i = 0; i < fluid.length; i++) {
                for (int x = 0; x < fluid.length; x++) {
                    for (int y = 0; y < fluid.length; y++) {
                        fluid[x][y] = Math.min(fluid[x][y], fluid[x][i] + fluid[i][y]);
                    }
                }
            }

            if (fluid[0][n + 1] == INF) {
                sb.append(fail).append("\n");
            } else {
                sb.append(success).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static int beersOf(Location location1, Location location2) {
        int distance = Math.abs(location1.x - location2.x) + Math.abs(location1.y - location2.y);
        return distance % 50 == 0 ? distance / 50 : distance / 50 + 1;
    }
}