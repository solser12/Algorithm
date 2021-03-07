package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1647_도시분할계획 {

    static int N, M;
    static int[] head, rank;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int dist = Integer.parseInt(st.nextToken());
            pq.add(new Edge(from, to, dist));
        }

        make();
        int cnt = 0, ans = 0;

        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            if (union(e.from, e.to)) {
                ans += e.dist;
                cnt++;
            }
            if (cnt == N-2) break;
        }

        System.out.println(ans);
        br.close();
    }

    static void make () {
        head = new int[N];
        rank = new int[N];
        for (int i = 0; i < N; i++) head[i] = i;
    }

    static boolean union (int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false;

        if (rank[a] >= rank[b]) {
            head[b] = a;
            if (rank[a] == rank[b]) rank[a]++;
        }
        else head[b] = a;

        return true;
    }

    static int find (int a) {
        if (head[a] == a) return a;
        return head[a] = find(head[a]);
    }

    static class Edge implements Comparable<Edge> {
        int from, to, dist;

        public Edge(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.dist, o.dist);
        }
    }
}
