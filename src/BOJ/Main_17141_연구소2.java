package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17141_연구소2 {

    static int M, N;
    static int cnt = 0, vidx = 0, ans = Integer.MAX_VALUE;
    static int[][] lab;
    static Loc[] virus = new Loc[10];
    static int[] perm;
    static int[][] dir = {{1, -1, 0, 0}, {0, 0, 1, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 2) {
                    virus[vidx++] = new Loc(i, j);
                    input = 0;
                }
                if (input == 0) cnt++;
                lab[i][j] = input;
            }
        }

        perm = new int[vidx];

        for (int i = vidx - M; i < vidx; i++) {
            perm[i] = 1;
        }

        do {
            check();
        } while (nextPermutation());

        System.out.println(ans != Integer.MAX_VALUE ? ans : -1);
        br.close();
    }

    static void check() {
        int[][] tempLab = new int[N][];
        int tcnt = cnt;

        for (int i = 0; i < N; i++) tempLab[i] = lab[i].clone();

        int time = -1;

        Queue<Loc> q = new LinkedList<>();
        for (int i = 0; i < vidx; i++) {
            if (perm[i] == 1) {
                q.add(virus[i]);
                tempLab[virus[i].x][virus[i].y] = 2;
                tcnt--;
            }
        }

        while (!q.isEmpty()) {
            time++;
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Loc loc = q.poll();
                for (int d = 0; d < 4; d++) {
                    int dx = loc.x + dir[0][d];
                    int dy = loc.y + dir[1][d];
                    if (dx >= 0 && dx < N && dy >= 0 && dy < N && tempLab[dx][dy] == 0) {
                        q.add(new Loc(dx, dy));
                        tempLab[dx][dy] = 2;
                        tcnt--;
                    }
                }
            }
        }

        if (tcnt == 0) {
            ans = Math.min(ans, time);
        }
    }

    static boolean nextPermutation() {
        int i = vidx - 1;
        while (i > 0 && perm[i-1] >= perm[i]) i--;
        if (i == 0) return false;

        int j = vidx - 1;
        while (perm[i-1] >= perm[j]) j--;

        int temp = perm[i-1];
        perm[i-1] = perm[j];
        perm[j] = temp;

        j = vidx - 1;
        while (i < j) {
            temp = perm[i];
            perm[i++] = perm[j];
            perm[j--] = temp;
        }
        return true;
    }

    static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
