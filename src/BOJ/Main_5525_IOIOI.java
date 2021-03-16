package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5525_IOIOI {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();

        // IO 반복 수
        int cnt = 0;

        for (int i = 0; i < M; i+=2) {

            if (S[i] == 'O') {  // O이면
                cnt = 0;
                i--;
                continue;
            }

            // 만약 cnt가 N개 라면
            if (cnt == N) {
                ans++;          // ans 증가
                if (i < M - 1 && S[i+1] == 'I') {  // 바로 다음이 I이면 초기화
                    cnt = 0;
                    i--;
                }
                continue;
            }

            if (i < M - 1 && S[i+1] == 'O') cnt++;
            else {
                i--;
                cnt = 0;
            }
        }

        System.out.println(ans);
        br.close();
    }
}
