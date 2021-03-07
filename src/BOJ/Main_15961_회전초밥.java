package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15961_회전초밥 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] list = new int[N + k - 1];
        int ans = 0, cnt = 0;
        int[] check = new int[d+1];

        for(int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        for(int i = N; i < N + k - 1; i++) {
            list[i] = list[i - N];
        }

        for (int i = 0; i < k; i++) {
            if(check[list[i]] == 0) cnt++;
            check[list[i]]++;
            ans = cnt > ans ? (check[c] == 0 ? cnt+1 : cnt) : ans;
        }

        for (int i = 0; i < N-1; i++) {
            check[list[i]]--;
            if(check[list[i]] == 0) cnt--;

            if(check[list[i+k]] == 0) cnt++;
            check[list[i+k]]++;

            if  (check[c] == 0) ans = ans < cnt + 1 ? cnt + 1 : ans;
            else ans = ans < cnt ? cnt : ans;
            if (ans == k + 1) break;
        }

        System.out.println(ans);
        br.close();
    }
}
