package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_8958_OX퀴즈 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String input = br.readLine();

            int ans = 0, cnt = 1;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == 'O') {
                    ans += cnt;
                    cnt++;
                } else {
                    cnt = 1;
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
