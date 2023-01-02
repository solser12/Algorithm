package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1110_더하기_사이클 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int past = N;
        int now = (N / 10) + (N % 10);
        int cnt = 1;
        while (N != ((past % 10) * 10) + (now % 10)) {
            int temp = past;
            past = now;
            now = (temp % 10) + (now % 10);
            cnt++;
        }

        System.out.println(cnt);
        br.close();
    }
}
