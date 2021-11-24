package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14868_문명 {

    public static int N, K, count;
    public static int[][] map;
    public static int[] parents;
    public static Queue<Loc> q = new LinkedList<>();
    public static int[][] dt = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        count = K;
        map = new int[N][N];
        parents = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = N - Integer.parseInt(st.nextToken());
            map[x][y] = i;
            parents[i] = i;
            q.offer(new Loc(x, y, i));
        }

        System.out.println(bfs());
        br.close();
    }

    public static void start() {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            Loc loc = q.poll();
            int myNum = find(loc.num);
            findCivil(loc.x, loc.y, myNum);
            q.offer(new Loc(loc.x, loc.y, myNum));
        }
    }

    public static int bfs() {

        start();

        int year = 0;
        while (count != 1) {
            year++;
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Loc loc = q.poll();
                int myNum = find(loc.num);
                for (int d = 0; d < 4; d++) {
                    int dx = loc.x + dt[d][0];
                    int dy = loc.y + dt[d][1];
                    if (checkRange(dx, dy)) {
                        if (map[dx][dy] == 0) {
                            map[dx][dy] = myNum;
                            q.offer(new Loc(dx, dy, myNum));
                            findCivil(dx, dy, myNum);
                        }
                    }
                }
            }
        }

        return year;
    }

    public static void findCivil(int x, int y, int num) {
        for (int d = 0; d < 4; d++) {
            int dx = x + dt[d][0];
            int dy = y + dt[d][1];
            if (checkRange(dx, dy) && map[dx][dy] != 0 && !checkParent(num, map[dx][dy])) {
                union(num, map[dx][dy]);
                count--;
            }
        }
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static int find(int num) {
        if (parents[num] == num) return num;
        return parents[num] = find(parents[num]);
    }

    public static boolean checkParent(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        return aParent == bParent;
    }

    public static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        if (aParent == bParent) return;

        parents[aParent] = bParent;
    }

    public static class Loc {
        int x, y, num;

        public Loc(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}
