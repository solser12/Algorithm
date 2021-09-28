package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2110_공유기설치 {

    static int N, C, ans = 0;
    static int[] floor;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        floor = new int[N];
        for (int i = 0; i < N; i++) {
            floor[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(floor);

        binarySearch();

        System.out.println(ans);
        br.close();
    }

    public static void binarySearch() {
        int left = 1, right = floor[N-1];
        while (left <= right) {
            int mid = (left + right) / 2;

            if (check(mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    public static boolean check(int mid) {
        int cnt = 1;
        int temp = floor[0];
        for (int i = 1; i < N; i++) {

            if (floor[i] - temp >= mid) {
                cnt++;
                temp = floor[i];
            }

            if (cnt == C) return true;
        }

        return false;
    }
}
