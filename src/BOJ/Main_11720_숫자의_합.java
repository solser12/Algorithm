package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11720_숫자의_합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        String input = br.readLine();
        for (int i = 0; i < N; i++) {
            ans += input.charAt(i) - '0';
        }

        System.out.println(ans);
        br.close();
    }
}
