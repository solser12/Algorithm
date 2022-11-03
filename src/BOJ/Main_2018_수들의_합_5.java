package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2018_수들의_합_5 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans = 1, sum = 0, left = 1, right = 1;
        while (left <= right && right <= N) {
            if (sum < N) {
                sum += right++;
            } else {
                if (sum == N) {
                    ans++;
                }
                sum -= left++;
            }
        }

        System.out.println(ans);
        br.close();
    }
}