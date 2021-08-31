package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3079_입국심사 {

    static int N, M;
    static int[] list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);

        System.out.println(binarySearch());
        br.close();
    }

    public static long binarySearch() {
        long ans = Long.MAX_VALUE;
        long min = 1, max = (long) list[0] * M;
        while (min <= max) {
            long mid = (min + max) / 2;

            if (check(mid)) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return ans;
    }

    public static boolean check(long mid) {
        long cnt = 0;
        for (int i : list) {
            cnt += (mid / i);
            if (cnt >= M) return true;
        }

        return  false;
    }
}
