package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1681_줄세우기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int ans = 1;

        for (int i = 0; i < N; i++) {
            int temp = ans;
            int cnt = 1;
            boolean flag = false;
            while(true) {
                int mod = temp % 10;
                if (mod == L) {
                    ans += cnt;
                    i--;
                    flag = true;
                    break;
                }
                cnt *= 10;
                temp /= 10;
                if (temp == 0) {
                    if (!flag && i != N-1) ans++;
                    break;
                }
            }
        }

        System.out.println(ans);
        br.close();
    }
}
