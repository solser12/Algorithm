import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DisjointSet {

    static int[] parents, rank;
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()) + 1;
        M = Integer.parseInt(st.nextToken());
        parents = new int[N];
        rank = new int[N];

        make();

        int type;
        int a, b;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            type = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (type == 0) {
                union(a, b);
            } else {
                sb.append(check(a, b) ? "YES\n" : "NO\n");
            }
        }

        System.out.println(sb.toString());
        br.close();

    }

    static void make() {
        for (int i = 0; i < N; i++) {
            parents[i] = i;
            rank[i] = 0;
        }
    }

    static int find(int num) {
        if (parents[num] == num) return num;
        return parents[num] = find(parents[num]);
    }

    static boolean check(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        return aRoot == bRoot;
    }


    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) return;

        if (rank[aRoot] < rank[bRoot]) {
            parents[aRoot] = bRoot;
        } else {
            parents[bRoot] = aRoot;
            if (rank[aRoot] == rank[bRoot]) rank[aRoot]++;
        }
    }
}