package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1748_수이어쓰기1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans = 0, cnt = 1, mul = 9;

        while (N > 0) {
            ans += Math.min(N, mul) * cnt;
            N -= mul;
            mul *= 10;
            cnt++;
        }

        System.out.println(ans);
        br.close();
    }
}
