package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2960_에라토스테네스의체 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[N + 1];
        int ans = 0, cnt = 0;
        for (int i = 2; i <= N; i++) {
            if (arr[i]) continue;
            for (int j = i; j <= N; j += i) {
                if (arr[j]) continue;
                arr[j] = true;
                cnt++;
                if (cnt == K) {
                   ans = j;
                   i = N + 1;
                   break;
                }
            }
        }

        System.out.println(ans);
        br.close();
    }
}
