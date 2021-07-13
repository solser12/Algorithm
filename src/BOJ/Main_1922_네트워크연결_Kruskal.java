package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1922_네트워크연결_Kruskal {

    static int N, M;
    static Edge[] list;
    static int[] parent, rank;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new Edge[M];
        make();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[i] = new Edge(from, to, cost);
        }

        Arrays.sort(list);

        int cnt = 0;
        int ans = 0;

        for (int i = 0; i < M; i++) {
            if (union(list[i].from, list[i].to)) {
                cnt++;
                ans += list[i].cost;
            }

            if (cnt == N - 1) {
                break;
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static class Edge implements Comparable<Edge> {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void make() {
        parent = new int[N + 1];
        rank = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }
    }

    public static boolean union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);

        if (aParent == bParent) return false;

        if (rank[aParent] >= rank[bParent]) {
            parent[bParent] = aParent;
            if (rank[aParent] == rank[bParent]) {
                rank[aParent]++;
            }
        } else {
            parent[aParent] = bParent;
        }

        return true;
    }

    public static int find(int num) {
        if (parent[num] == num) return num;
        return parent[num] = find(parent[num]);
    }
}
