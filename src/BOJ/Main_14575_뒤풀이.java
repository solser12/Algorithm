package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14575_뒤풀이 {

    static int N, T, minSum = 0;
    static int[] maxArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        maxArr = new int[N];

        int min = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            maxArr[i] = right;
            min = Math.max(left, min);
            max = Math.max(right, max);
            minSum += left;
        }

        int ans = binarySearch(min, max);

        System.out.println(ans);
        br.close();
    }

    public static int binarySearch(int left, int right) {

        int ans = -1;
        int min = left, max = right;
        while (min <= max) {
            int mid = (max + min) >> 1;
            int maxSum = 0;
            for (int i = 0; i < N; i++) {
                maxSum += Math.min(mid, maxArr[i]);
            }

            if (minSum <= T && T <= maxSum) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return ans;
    }
}
