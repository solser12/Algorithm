package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1069_집으로 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        double dist = Math.sqrt((X * X) + (Y * Y));

        double ans = dist;

        int jumpCnt = (int) (dist / D);
        double lastDist = dist % D;

        if (lastDist > 0) {
            if (jumpCnt == 0) {
                ans = Math.min(ans, Math.min(T * 2, T + (D - dist)));
            } else {
                ans = Math.min(ans, Math.min(T * (jumpCnt + 1), T * (jumpCnt) + lastDist));
            }
        } else {
            ans = Math.min(ans, jumpCnt * T);
        }

        System.out.println(ans);
        br.close();
    }
}
