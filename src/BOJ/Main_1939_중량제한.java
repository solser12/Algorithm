package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1939_중량제한 {

    static int N, M, start, end;
    static ArrayList<Bridge>[] bridges;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        bridges = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            bridges[i] = new ArrayList<>();
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            bridges[a].add(new Bridge(b, c));
            bridges[b].add(new Bridge(a, c));
            max = Math.max(max, c);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken()) - 1;
        end = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(binarySearch(max));

        br.close();
    }

    public static int binarySearch(int weight) {
        int ans = 0, min = 0, max = weight;
        while (min <= max) {
            int mid = (min + max) >> 1;
            if (check(mid)) {
                ans = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return ans;
    }

    public static boolean check(int weight) {

        Queue<Bridge> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        q.offer(new Bridge(0, 0));
        visited[start] = true;

        while (!q.isEmpty()) {
            Bridge poll = q.poll();
            if (poll.island == end) return true;

            for (Bridge b : bridges[poll.island]) {
                if (visited[b.island] || b.limit < weight) continue;
                visited[b.island] = true;
                q.add(b);
            }
        }

        return false;
    }

    public static class Bridge {
        int island, limit;

        public Bridge(int island, int limit) {
            this.island = island;
            this.limit = limit;
        }
    }
}
