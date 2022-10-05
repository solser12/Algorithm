package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14562_태권왕 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int C = Integer.parseInt(br.readLine());
        for (int c = 0; c < C; c++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            sb.append(bfs(s, t)).append('\n');
        }

        System.out.print(sb);
        br.close();
    }

    public static int bfs(int s, int t) {

        Queue<State> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        q.offer(new State(s, t));
        set.add(stateToInt(s, t));

        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                State state = q.poll();
                if (state.s == state.t) {
                    return cnt;
                }
                int a = state.s + state.s;
                int b = state.t + 3;
                int num = stateToInt(a, b);
                if (a < 1000 && !set.contains(num)) {
                    q.offer(new State(a, b));
                    set.add(num);
                }

                a = state.s + 1;
                b = state.t;
                num = stateToInt(a, b);
                if (!set.contains(num)) {
                    q.offer(new State(a, b));
                    set.add(num);
                }
            }
            cnt++;
        }

        return cnt;
    }

    public static State intToState(int num) {
        return new State(num / 1000, num % 1000);
    }

    public static int stateToInt(int s, int t) {
        return s * 1000 + t;
    }

    public static class State {

        int s, t;

        public State(int s, int t) {
            this.s = s;
            this.t = t;
        }
    }
}
