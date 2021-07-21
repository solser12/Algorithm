package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_14226_이모티콘 {

    static int S;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = Integer.parseInt(br.readLine());
        dp = new int[S + 1][S + 1];
        for (int i = 0; i < S + 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        System.out.println(check());

        br.close();
    }

    public static int check() {

        Queue<State> q = new LinkedList<>();
        q.add(new State(1, 0));
        dp[1][0] = 0;
        int time = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                State state = q.poll();

                // 복사하기
                if (dp[state.num][state.num] > time) {
                    dp[state.num][state.num] = time;
                    q.add(new State(state.num, state.num));
                }

                // 붙여넣기
                if (state.num + state.clip <= S && state.clip != 0 && dp[state.num + state.clip][state.clip] > time) {
                    if (state.num + state.clip == S) return time;
                    dp[state.num + state.clip][state.clip] = time;
                    q.add(new State(state.num + state.clip, state.clip));
                }

                // 삭제하기
                if (state.num - 1 > 0 && dp[state.num - 1][state.clip] > time) {
                    if (state.num - 1 == S) return time;
                    dp[state.num - 1][state.clip] = time;
                    q.add(new State(state.num - 1, state.clip));
                }
            }
            time++;
        }
        return time;
    }

    public static class State {
        int num, clip;

        public State(int num, int clip) {
            this.num = num;
            this.clip = clip;
        }
    }
}
