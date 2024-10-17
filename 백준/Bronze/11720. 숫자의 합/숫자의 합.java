import static java.lang.Integer.*;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        String input = br.readLine();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += input.charAt(i) - '0';
        }
        System.out.println(sum);
    }

}