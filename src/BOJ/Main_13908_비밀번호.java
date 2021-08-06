package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13908_비밀번호 {

    static int n, m, ans = 0;
    static int[] know, number;
    static int[] count = new int[10];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        number = new int[n];
        know = new int[m];

        if (m > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                know[i] = Integer.parseInt(st.nextToken());
            }
        }

        find(0);

        System.out.println(ans);
        br.close();
    }

    public static void find(int depth) {

        if (depth == n) {
            for (int k : know) {
                if (count[k] == 0) return;
            }

            ans++;
            return;
        }

        for (int i = 0; i <= 9; i++) {
            count[i]++;
            number[depth] = i;
            find(depth + 1);
            count[i]--;
        }
    }
}
