import static java.lang.Integer.*;
import static java.lang.Double.*;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());

        double[] list = new double[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = parseDouble(st.nextToken());
        }
        Arrays.sort(list);

        int maxIndex = n - 1;
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum += (list[i] / list[maxIndex]) * 100;
        }
        System.out.println(sum / n);
    }
}