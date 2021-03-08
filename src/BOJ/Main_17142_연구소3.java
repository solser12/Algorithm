package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_17142_연구소3 {

    static int M, N, area = 0, virusCnt = 0, ans = Integer.MAX_VALUE;
    static ArrayList<Loc> virusLoc = new ArrayList<>();
    static int[][] lab;
    static int[] perm;
    static int[][] dt = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

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
                // 바이러스 위치 미리 저장
                if (input == 2) virusLoc.add(new Loc(i, j));
                lab[i][j] = input;

                // 벽이 아닌 곳은 전부 count
                if (input != 1) area++;
            }
        }

        area -= M;
        virusCnt = virusLoc.size();
        perm = new int[virusCnt];
        Arrays.fill(perm, virusCnt - M, virusCnt, 1);
        do {
            System.out.println();
            System.out.println();
            System.out.println();
            bfs();
        } while (nextPerm());

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
        br.close();
    }

    static void bfs() {
        // 연구실 복사
        int[][] tempLab = new int[N][];
        for (int i = 0; i < N; i++) {
            tempLab[i] = lab[i].clone();
        }

        // 빈공간 복사
        int tempNon = area;

        Queue<Loc> q = new LinkedList<>();
        for (int i = 0; i < virusCnt; i++) {
            if (perm[i] == 1) {
                Loc loc = virusLoc.get(i);
                q.add(loc);
                tempLab[loc.x][loc.y] = 3;
            }
        }

        int sec = 0;
        while(!q.isEmpty()) {

            int size = q.size();
            for (int s = 0; s < size; s++) {
                Loc loc = q.poll();
                for (int d = 0; d < 4; d++) {
                    int dx = loc.x + dt[d][0];
                    int dy = loc.y + dt[d][1];
                    if (dx >= 0 && dx < N && dy >= 0 && dy < N) {
                        if (tempLab[dx][dy] == 1 || tempLab[dx][dy] == 3) continue;
                        q.add(new Loc(dx, dy));
                        tempLab[dx][dy] = 3;
                        tempNon--;
                    }
                }
            }

            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            for (int a[] : tempLab) {
                for (int b : a) {
                    System.out.print(b + " ");
                }
                System.out.println();
            }
            System.out.println(sec);

            if (tempNon == 0) {
                ans = Math.min(ans, sec);
                System.out.println("!!" + sec);
                return;
            }

            sec++;
            if (ans < sec) return;


        }


    }

    static boolean nextPerm() {
        int i = virusCnt - 1;
        while (i > 0 && perm[i-1] >= perm[i]) i--;
        if (i == 0) return false;

        int j = virusCnt - 1;
        while(perm[i-1] >= perm[j]) j--;

        int temp = perm[i-1];
        perm[i-1] = perm[j];
        perm[j] = temp;

        j = virusCnt - 1;
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
