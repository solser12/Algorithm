package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1233_사칙연산유효성검사 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N, result, cnt;
        char c;
        StringTokenizer st;

        for (int tc = 1; tc <= 10; ++tc) {

            N = Integer.parseInt(br.readLine());

            result = 1;

            sb.append('#').append(tc).append(' ');

            for (int i = 0; i < N; ++i) {
                st = new StringTokenizer(br.readLine());
                cnt = st.countTokens();
                st.nextToken();
                c = st.nextToken().charAt(0);

                if (cnt < 4 && (c == '+' || c == '-' || c == '/'|| c == '*')) {
                    result = 0;
                }
                else if (cnt >= 4 && (c >= '0' && c <= '9')) {
                    result = 0;
                }
            }
            sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
