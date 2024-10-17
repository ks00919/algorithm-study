import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = 1000 - parseInt(br.readLine());

        int count = 0;
        int[] banknode = { 500, 100, 50, 10, 5};
        for (int i = 0; i < banknode.length; i++) {
            count += money / banknode[i];
            money %= banknode[i];
        }

        System.out.println(count + money);
    }
}