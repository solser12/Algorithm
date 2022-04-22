package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16900_이름정하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String S = st.nextToken();
        int K = Integer.parseInt(st.nextToken());

        int[] table = new int[S.length()];
        int j = 0;
        for (int i = 1; i < S.length(); i++) {
            while (j > 0 && S.charAt(i) != S.charAt(j)) {
                j = table[j - 1];
            }
            if (S.charAt(i) == S.charAt(j)) {
                table[i] = ++j;
            }
        }

        long ans = S.length();
        ans += (long) (S.length() - table[table.length - 1]) * (K - 1);

        System.out.println(ans);
        br.close();
    }
}