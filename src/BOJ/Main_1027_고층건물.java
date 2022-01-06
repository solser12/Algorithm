package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1027_고층건물 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] building = new long[N];
        int[] count = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <  N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (check(i, j, building)) {
                    count[i]++;
                    count[j]++;
                }
            }
        }

        int ans = 0;
        for (int i : count) {
            ans = Math.max(i, ans);
        }

        System.out.println(ans);
        br.close();
    }

    public static boolean check(int start, int end, long[] building) {
        for (int i = start + 1; i < end; i++) {
            if (ccw(start, building[start], end, building[end], i, building[i]) * ccw(start, building[start], end, building[end], i, 0) <= 0
                    && ccw(i, building[i], i, 0, start, building[start]) * ccw(i, building[i], i, 0, end, building[end]) <= 0) {
                return false;
            }
        }
        return true;
    }

    public static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long result = ((x1 * y2) + (x2 * y3) + (x3 * y1)) - ((y1 * x2) + (y2 * x3) + (y3 * x1));
        return Long.compare(result, 0);
    }
}
