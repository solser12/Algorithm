package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16401_과자나눠주기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] crackers = new int[N];

        int left = 1, right = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crackers[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, crackers[i]);
        }

        int ans = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;

            int num = 0;
            for (int cracker : crackers) {
                num += cracker / mid;
            }

            if (num >= M) {
                ans = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
        br.close();
    }
}
