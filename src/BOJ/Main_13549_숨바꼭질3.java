package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_13549_숨바꼭질3 {

    static int N, K;
    static int[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);

        System.out.println(check());

        br.close();
    }

    public static int check() {

        PriorityQueue<Loc> pq = new PriorityQueue<>();
        pq.add(new Loc(N, 0));
        visited[N] = 0;

        while (!pq.isEmpty()) {
            Loc loc = pq.poll();

            if (loc.x == K) {
                return loc.time;
            }

            // 순간이동
            if (loc.x <= 50000 && visited[loc.x * 2] > loc.time) {
                pq.add(new Loc(loc.x * 2, loc.time));
                visited[loc.x * 2] = loc.time;
            }

            // 그냥 이동
            if (loc.x + 1 <= 100000 && visited[loc.x + 1] > loc.time + 1) {
                pq.add(new Loc(loc.x + 1, loc.time + 1));
                visited[loc.x + 1] = loc.time + 1;
            }

            if (loc.x - 1 >= 0 && visited[loc.x - 1] > loc.time + 1) {
                pq.add(new Loc(loc.x - 1, loc.time + 1));
                visited[loc.x - 1] = loc.time + 1;
            }
        }

        return -1;
    }

    public static class Loc implements Comparable<Loc> {
        int x, time;

        public Loc(int x, int time) {
            this.x = x;
            this.time = time;
        }

        @Override
        public int compareTo(Loc o) {
            return this.time - o.time;
        }
    }
}
