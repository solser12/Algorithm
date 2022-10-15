package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1789_수들의합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());
        long num = 1;
        int ans = 0;

        while (true) {
            ans++;
            S -= num++;

            if (S == 0) {
                break;
            } else if (S < 0) {
                ans--;
                break;
            }
        }

        System.out.println(ans);
        br.close();
    }
}
