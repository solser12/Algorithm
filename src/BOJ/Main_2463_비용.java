package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2463_비용 {

    public static final int MOD = 1000000000;
    public static int N, M;
    public static int[] parents, childCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[M];
        long totalWeight = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x, y, w;
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;
            w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(Math.min(x, y), Math.max(x, y), w);
            totalWeight += w;
        }
        Arrays.sort(edges);

        make();

        long ans = 0;
        for (Edge edge : edges) {
            ans += totalWeight * union(edge.start, edge.end);
            ans %= MOD;
            totalWeight -= edge.weight;
        }

        System.out.println(ans);
        br.close();
    }

    public static int find(int num) {
        if (parents[num] == num) return num;
        return parents[num] = find(parents[num]);
    }

    public static long union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        if (aParent == bParent) return 0;

        parents[bParent] = aParent;
        long result = (long) childCount[aParent] * childCount[bParent];
        childCount[aParent] += childCount[bParent];
        childCount[bParent] = 0;
        return result;
    }

    public static void make() {
        parents = new int[N];
        childCount = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
            childCount[i] = 1;
        }
    }

    public static class Edge implements Comparable<Edge> {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return o.weight - this.weight;
        }
    }
}
