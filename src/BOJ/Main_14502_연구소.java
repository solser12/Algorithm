package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소 {

    static int N, M, count = 0, ans = 0;
    static int[][] lab;
    static int[][] dir = {{1, -1, 0, 0}, {0, 0, 1, -1}};
    static ArrayList<Loc> virus = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 0) count++;
                else if (lab[i][j] == 2) virus.add(new Loc(i, j));
            }
        }

        count -= 3;

        check(0, -1, 0);

        System.out.println(ans);
        br.close();
    }

    static void check(int x, int y, int cnt) {

        if (cnt == 3) {
            bfs();
            return;
        }

        int j = y + 1;
        for (int i = x; i < N; i++) {
            while(j < M) {
                if (lab[i][j] == 0) {
                    lab[i][j] = 1;
                    check(i, j, cnt + 1);
                    lab[i][j] = 0;
                }
                j++;
            }
            j = 0;
        }
    }

    static void bfs() {
        int[][] tempLab = new int[N][];
        int vcnt = count;

        for (int i = 0; i < N; i++) tempLab[i] = lab[i].clone();

        Queue<Loc> q = new LinkedList<>();
        for (Loc loc : virus) {
            tempLab[loc.x][loc.y] = 2;
            q.add(loc);
        }

        while (!q.isEmpty()) {
            Loc loc = q.poll();
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dir[0][d];
                int dy = loc.y + dir[1][d];
                if (dx >= 0 && dx < N && dy >= 0 && dy < M && tempLab[dx][dy] == 0) {
                    q.add(new Loc(dx, dy));
                    tempLab[dx][dy] = 2;
                    vcnt--;
                }
            }
        }

        ans = Math.max(ans, vcnt);
    }

    static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
