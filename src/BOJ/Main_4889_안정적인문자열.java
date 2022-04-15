package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4889_안정적인문자열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int no = 1;
        String input;
        while (true) {

            input = br.readLine();
            if (input.length() > 0 && input.charAt(0) == '-') {
                break;
            }

            sb.append(no).append('.').append(' ');

            int ans = 0, count = 0;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                if (c == '{') {
                    count++;
                } else if (c == '}') {
                    if (count == 0) {
                        ans++;
                        count++;
                    } else {
                        count--;
                    }
                }
            }

            ans += count / 2;

            sb.append(ans).append('\n');
            no++;
        }

        System.out.println(sb);
        br.close();
    }
}
