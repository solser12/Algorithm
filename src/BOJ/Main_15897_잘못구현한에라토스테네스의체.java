package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15897_잘못구현한에라토스테네스의체 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long ans = 0;
        for (int i = 1; i < n;) {
            int count = ((n - 1) / i) + 1;
            int jump = ((n - 1) % i) / count + 1;
            ans += (long) jump * count;
            i += jump;
        }
        ans++;

        System.out.println(ans);
        br.close();
    }
}
