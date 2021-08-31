package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2805_나무자르기 {

    static int N, M;
    static int[] trees;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];
        
        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(trees[i], max);
        }

        System.out.println(binarySearch(max));
        br.close();
    }

    public static int binarySearch(int max) {
        int ans = 0;
        int low = 0, high = max;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static boolean check(int mid) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (trees[i] < mid) continue;
            sum += trees[i] - mid;
            if (sum >= M) return true;
        }
        return false;
    }
}
