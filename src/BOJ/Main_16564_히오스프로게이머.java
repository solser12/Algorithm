package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16564_히오스프로게이머 {

    static int N, K;
    static int[] characters;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        characters = new int[N];
        for (int i = 0; i < N; i++) {
            characters[i] = Integer.parseInt(br.readLine());
            min = Math.min(characters[i], min);
        }

        System.out.println(binarySearch(min));
        br.close();
    }

    public static long binarySearch(int num) {
        long ans = 0, min = num, max = num + K;
        while (min <= max) {
            long mid = (min + max) >> 1;
            if (check(mid)) {
                ans = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return ans;
    }

    public static boolean check(long level) {
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            if (level <= characters[i]) continue;
            cnt += level - characters[i];
            if (cnt > K) return false;
        }

        return true;
    }
}
