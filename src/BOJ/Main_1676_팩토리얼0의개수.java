package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1676_팩토리얼0의개수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 5; i <= n; i += 5) {
            int temp = i;
            while (temp % 5 == 0) {
                ans++;
                temp /= 5;
            }
        }

        System.out.println(ans);
        br.close();
    }
}