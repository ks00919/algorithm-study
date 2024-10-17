import static java.lang.Integer.*;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int i = parseInt(br.readLine());

        System.out.println(input.charAt(i - 1));
    }

}