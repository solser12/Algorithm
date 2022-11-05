package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14912_숫자_빈도수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) - '0' == d) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
        br.close();
    }
}
