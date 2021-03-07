package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18513_샘터 {

    static int N, K;
    static long total = 0;
    static boolean[] map = new boolean[200000001];
    static Queue<House> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken()) + 100000000;
            q.add(new House(t, t));
            map[t] = true;
        }

        bfs();

        System.out.println(total);
        br.close();
    }

    static void bfs() {
        while(!q.isEmpty()) {
            House h = q.poll();
            for (int i = -1; i <= 1; i+=2) {
                int d = h.x + i;
                if (d >= 0 && d < 200000001 && !map[d]) {
                    total += Math.abs(d - h.s);
                    map[d] = true;
                    K--;
                    if (K == 0) return;
                    q.add(new House(d, h.s));
                }
            }
        }
    }

    static class House {
        int x, s;

        public House(int x, int s) {
            this.x = x;
            this.s = s;
        }
    }
}
