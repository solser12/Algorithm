package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;;
import java.util.StringTokenizer;

public class Main_2491_수열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int cnt1 = 1, cnt2 = 1, ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N-1; i++) {
            int n = arr[i+1];
            int o = arr[i];
            if (n < o) {
                ans = Math.max(ans, cnt1);
                cnt1 = 0;
            }

            if (n > o) {
                ans = Math.max(ans, cnt2);
                cnt2 = 0;
            }

            cnt1++;
            cnt2++;
        }
        ans = Math.max(ans, cnt1);
        ans = Math.max(ans, cnt2);

        System.out.println(ans);
        br.close();
    }
}
