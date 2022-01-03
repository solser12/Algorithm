package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10216_CountCircleGroups {

    public static int[] roots;
    public static Camp[] camps;
    public static int groupCnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            groupCnt = N;
            camps = new Camp[N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                camps[i] = new Camp(x, y, r);
            }

            make(N);
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (check(i, j) && union(i, j)) groupCnt--;
                }
            }

            sb.append(groupCnt).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static boolean check(int a, int b) {
        double dist = Math.sqrt(square(camps[a].x - camps[b].x) + square(camps[a].y - camps[b].y));
        int r = camps[a].r + camps[b].r;

        return dist <= r;
    }

    public static int square(int num) {
        return num * num;
    }


    public static void make(int N) {
        roots = new int[N];
        for (int i = 0; i < N; i++) {
            roots[i] = i;
        }
    }

    public static int find(int num) {
        if (roots[num] == num) return num;
        return roots[num] = find(roots[num]);
    }

    public static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;

        roots[bRoot] = aRoot;
        return true;
    }

    public static class Camp {
        int x, y, r;

        public Camp(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
}
