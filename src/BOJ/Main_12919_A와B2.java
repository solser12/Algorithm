package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_12919_A와B2 {

    static char[] S, T;
    static int d, ans = 0;
    static int aCnt = 0, bCnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine().toCharArray();
        d = S.length;
        for (char c : S) {
            if (c == 'A') aCnt++;
            else bCnt++;
        }

        T = br.readLine().toCharArray();
        int a = 0, b = 0;
        int left = 0, right = T.length - 1;
        for (char c : T) {
            if (c == 'A') a++;
            else b++;
        }

        dfs(T.length, left, right, a, b, false);

        System.out.println(ans);
        br.close();
    }

    public static void dfs(int depth, int left, int right, int a, int b, boolean reverse) {

        if (ans != 0) return;

        if (a < aCnt || b < bCnt) return;

        if (depth == d) {
            int idx = 0;
            if (reverse) {
                for (int i = right; i >= left; i--) {
                    if (T[i] != S[idx++]) return;
                }
            } else {
                for (int i = left; i <= right; i++) {
                    if (T[i] != S[idx++]) return;
                }
            }

            ans = 1;
            return;
        }

        if (reverse) {
            if (T[left] == 'A') dfs(depth - 1, left + 1, right, a - 1, b, true);
            if (T[right] == 'B') dfs(depth - 1, left, right - 1, a, b - 1, false);
        } else {
            if (T[right] == 'A') dfs(depth - 1, left, right - 1, a - 1, b, false);
            if (T[left] == 'B') dfs(depth - 1, left + 1, right, a, b - 1, true);
        }
    }
}
