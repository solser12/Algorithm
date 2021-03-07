package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1107_리모컨 {

    static boolean[] crash;
    static StringBuilder sb = new StringBuilder();
    static int N, ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ans = Math.abs(N - 100);
        crash = new boolean[10];

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int err = Integer.parseInt(st.nextToken());
                crash[err] = true;
            }
        }

        boolean bFlag = false;

        if (M == 0) ans = Math.min(ans, (N + "").length());
        else if (checking(N)) ans = (N + "").length();
        else if (M != 10) {
            for (int i = 1; i <= 1000001; i++) {
                if (checking(N + i)) bFlag = true;
                if (i <= N) {
                    if (checking(N - i)) bFlag = true;
                }
                if (bFlag) break;
            }
        }

        System.out.println(ans);
        br.close();
    }

    static boolean checking(int num) {
        String s = sb.append(num).toString();
        for (int i = 0; i < s.length(); i++) {
//            if (num == 0) System.out.println(s + " " + (s.charAt(i) - '0') + " " + crash[s.charAt(i) - '0']);
            if (crash[s.charAt(i) - '0']) {
                sb.setLength(0);
                return false;
            }
        }
//        System.out.println(num);
        ans = Math.min( ans, Math.abs(N - num) + s.length());
        sb.setLength(0);
        return true;
    }
}