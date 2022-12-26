package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_7567_그릇 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        char temp = input.charAt(0) == '(' ? ')' : '(';
        int len = 0;
        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);
            if (temp != now) {
                len += 5;
            }
            len += 5;
            temp = now;
        }

        System.out.println(len);
        br.close();
    }
}
