package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Kruskal_Prim {

    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int ans;
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (N >= M) ans = kruskal();
        else ans = prim();

        System.out.println(ans);
        br.close();
    }

    //////////////////////////////////////////////////////

    static Edge[] klist;
    static int[] head, rank;

    static int kruskal() throws IOException {
        klist = new Edge[M];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int dist = Integer.parseInt(st.nextToken());
            klist[i] = new Edge(from, to, dist);
        }

        Arrays.sort(klist);

        make();
        int cnt = 0, sum = 0;

        for (int i = 0; i < M; i++) {
            Edge e = klist[i];
            if (union(e.from, e.to)) {
                cnt++;
                sum += e.dist;
            }
            if (cnt == N-1) break;
        }

        return sum;
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

    //////////////////////////////////////////////

    static int prim() throws IOException {
        ArrayList<Edge>[] list = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            list[from].add(new Edge(from, to, dist));
            list[to].add(new Edge(to, from, dist));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[N+1];
        int sum = 0, cnt = 0;

        pq.add(new Edge(0, 1, 0));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (visit[e.to]) continue;
            visit[e.to] = true;

            cnt++;
            sum += e.dist;

            if (cnt == N) break;

            for (int i = 0; i < list[e.to].size(); i++) {
                Edge temp = list[e.to].get(i);
                if (!visit[temp.to]) pq.add(list[e.to].get(i));
            }
        }

        return sum;
    }
}