package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1654_랜선자르기 {

    static int K, N;
    static int[] cables;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        cables = new int[K];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < K; i++) {
            cables[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, cables[i]);
        }

        System.out.println(binarySearch(max));
        br.close();
    }

    public static int binarySearch(int max) {
        int ans = 0;
        long left = 1, right = max;
        while (left <= right) {
            long mid = (left + right) >> 1;

            if (check(mid)) {
                ans = (int) mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public static boolean check(long mid) {
        int cnt = 0;
        for (int i = 0; i < K; i++) {
            cnt += cables[i] / mid;
            if (cnt >= N) return true;
        }

        return false;
    }
}
