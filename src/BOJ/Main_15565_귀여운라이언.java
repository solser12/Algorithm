package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15565_귀여운라이언 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] ryan = new int[N];

        int idx = 0;
        int left = 0, right = 0;
        int ans = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int doll = Integer.parseInt(st.nextToken());
            if (doll == 1) {
                ryan[idx++] = i;
                if (idx == K) {
                    right = idx - 1;
                }
            }
        }

        if (idx == 0 || right == 0) {
            ans = -1;
        } else {
            while (right < idx) {
                ans = Math.min(ans, ryan[right] - ryan[left] + 1);
                right++;
                left++;
            }
        }

        System.out.println(ans);
        br.close();
    }
}
