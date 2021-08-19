package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1976_여행가자_DisjointSet {

    static int N, M;
    static int[] parents, rank;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        int start = -1, end;
        String ans = "YES";

        make();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken()) - 1;

            if (start == -1) {
                start = num;
                continue;
            }

            end = num;

            if (!check(start, end)){
                ans = "NO";
                break;
            }

            start = end;
        }

        System.out.println(ans);
        br.close();
    }

    public static boolean check(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        return aRoot == bRoot;
    }

    public static void make() {
        parents = new int[N];
        rank = new int[N];

        for (int i = 0; i < N; i++) {
            parents[i] = i;
            rank[i] = 0;
        }
    }

    public static int find(int num) {
        if (parents[num] == num) return num;
        return parents[num] = find(parents[num]);
    }

    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) return;

        if (rank[a] < rank[b]) {
            parents[aRoot] = bRoot;
        } else {
            parents[bRoot] = aRoot;
            if (rank[a] == rank[b]) {
                rank[a]++;
            }
        }
    }
}
