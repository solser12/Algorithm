package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2037_문자메시지 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken());
        int again = Integer.parseInt(st.nextToken());
        int sum = 0;
        int past = -1;

        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            int c = input.charAt(i);
            if (c == ' ') {
                sum += first;
                past = c;
                continue;
            }

            if (c >= 'W') {
                if (past >= 'W' && past <= 'Z') sum += again;
                sum += first + (c - 'W') * first;
            }
            else if (c >= 'T' && c <= 'V'){
                if (past >= 'T' && past <= 'V') sum += again;
                sum += first + (c - 'T') * first;
            }
            else if (c >= 'P' && c <= 'S') {
                if (past >= 'P' && past <= 'S') sum += again;
                sum += first + (c - 'P') * first;
            }
            else {
                int pdiv = (past - 'A') / 3;
                int div = (c - 'A') / 3;
                int mod = (c - 'A') % 3;
                sum += first + mod * first;
                if (pdiv == div) sum += again;
            }
            past = c;

        }

        System.out.println(sum);
        br.close();
    }
}
