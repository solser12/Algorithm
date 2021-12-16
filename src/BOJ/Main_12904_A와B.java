package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_12904_A와B {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String end = br.readLine();
        StringBuilder start = new StringBuilder(br.readLine());

        while (start.length() != end.length()) {
            if (start.charAt(start.length() - 1) == 'A') {
                start.setLength(start.length() - 1);
            } else {
                start.setLength(start.length() - 1);
                start.reverse();
            }
        }

        System.out.println(end.equals(start.toString()) ? 1 : 0);
        br.close();
    }
}
