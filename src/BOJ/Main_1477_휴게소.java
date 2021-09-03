package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1477_휴게소 {

    static int N, M, L;
    static int[] rest, restLen;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        rest = new int[N+1];
        restLen = new int[N+1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            rest[i] = Integer.parseInt(st.nextToken());
        }
        rest[N] = L;
        Arrays.sort(rest);

        int temp = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i <= N; i++) {
            restLen[i] = rest[i] - temp;
            max = Math.max(restLen[i], max);
            temp = rest[i];
        }

        System.out.println(binarySearch(max));
        br.close();
    }

    public static int binarySearch(int max) {
        int ans = 0;
        int left = 1, right = max;
        while (left <= right) {
            int mid = (left + right) >> 1;

            if (check(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static boolean check(int mid) {
        int cnt = 0;
        for (int i : restLen) {
            if (mid >= i) continue;
            cnt += Math.ceil(i / (double)mid) - 1;
        }

        if (cnt <= M) return true;
        return false;
    }
}
