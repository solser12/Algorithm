package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501_퇴사 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        Schedule[] schedules = new Schedule[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedules[i] = new Schedule(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            int temp = i + schedules[i].day;

            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            if (temp > N) continue;

            dp[temp] = Math.max(dp[temp], dp[i] + schedules[i].pay);
        }

        System.out.println(dp[N]);
        br.close();
    }

    public static class Schedule {
        int day, pay;

        public Schedule(int day, int pay) {
            this.day = day;
            this.pay = pay;
        }
    }
}
