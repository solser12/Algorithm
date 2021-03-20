package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14467_소가길은건너간이유1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int first = 0, ans = 0;
        int[] cows = new int[10];

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken()) - 1;
            int loc = Integer.parseInt(st.nextToken());
            System.out.println(cow + " 번째소 " + loc);
            // 첫 위치 지정 했는지 확인
            if ((first & (1 << cow)) > 0) {
                if (cows[cow] != loc) {
                    cows[cow] = loc;
                    ans++;
                }
            } else {
                first |= (1 << cow);
                cows[cow] = loc;
            }

            System.out.println(Arrays.toString(cows));
        }
        System.out.println(ans);
        br.close();
    }
}
