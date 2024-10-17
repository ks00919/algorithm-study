import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

public class Main {

    static int L, C;
    static int[] alphabet = new int[26];
    static char[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = parseInt(st.nextToken());
        C = parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        selected = new char[L];

        for (int i = 0; i < C; i++) {
            alphabet[st.nextToken().charAt(0) - 'a']++;
        }

        dfs(0, 0);

        System.out.println(sb);
    }

    public static void dfs(int depth, int index) {
        if (depth == L) {
            int count = getMo();
            if (getMo() > 0 && L - count > 1)
                sb.append(selected).append("\n");
            return;
        }

        for (int i = index; i < 26; i++) {
            if (alphabet[i] > 0) {
                alphabet[i]--;
                selected[depth] = (char) ('a' + i);
                dfs(depth + 1, i + 1);
                alphabet[i]++;
            }
        }
    }

    public static int getMo() {
        int count = 0;

        for (int i = 0; i < L; i++) {
            if (selected[i] == 'a' || selected[i] == 'e' || selected[i] == 'i' || selected[i] == 'o'
                    || selected[i] == 'u')
                count++;
        }
        return count;
    }

}