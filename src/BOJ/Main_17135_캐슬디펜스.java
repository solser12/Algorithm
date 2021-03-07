package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {

    static int M, D, N;
    static ArrayList<Integer>[] map;
    static ArrayList<Integer>[] tmap;
    static int[] nplist;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ans = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new ArrayList[N];
        for (int i = 0; i  < N; i++) map[i] = new ArrayList<>();
        nplist = new int[M];
        for (int i = M-1; i >= M-3; i--) {
            nplist[i] = 1;
        }

        for (int i = N-1; i >= 0; --i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) {
                int e  = Integer.parseInt(st.nextToken());
                if (e == 1) map[i].add(j);
            }
        }

        do {
            tmap = new ArrayList[N];
            for (int i = 0; i < N; i++) {       // 맵 복사
                tmap[i] = (ArrayList<Integer>) map[i].clone();
            }
            ans = Math.max(checking(), ans);
        } while(nextPermutation());


        System.out.println(ans);
        br.close();
    }

    static int checking() {
        // 궁수 위치
        int cnt = 0;
        int[] archers = new int[3];
        int idx = 0;
        for (int i = 0; i < M; i++) {
            if (nplist[i] == 1) archers[idx++] = i;
        }

        ArrayList<int[]> enemies = new ArrayList<>();
        for (int k = 0; k < N; k++) {
            enemies.clear();
            for (int d = k; d < k+D; d++) {
                if (d >= N) break;
                for (int j = 0; j < tmap[d].size(); j++) {
                    enemies.add(new int[] {d,tmap[d].get(j)});
                }
            }

            int[][] kill = new int[3][2];
            for (int[] i : kill) Arrays.fill(i, -1);
            for (int archer = 0; archer < archers.length; archer++) {
                int len = Integer.MAX_VALUE;
                for (int i = 0; i < enemies.size(); i++) {
                    int[] enemy = enemies.get(i);
                    int d = Math.abs(enemy[0] - (k-1)) + Math.abs(enemy[1] - archers[archer]);
                    if (d > D) continue;
                    if (len > d) {
                        len = d;
                        kill[archer][0] = enemy[0];
                        kill[archer][1] = enemy[1];
                    }
                    else if (len == d) {
                        if (kill[archer][1] > enemy[1]) {
                            kill[archer][0] = enemy[0];
                            kill[archer][1] = enemy[1];
                        }
                    }
                }
            }

            for (int i = 0; i < 3; i++) {
                if(kill[i][0] == -1) continue;
                for (int j = 0; j < tmap[kill[i][0]].size(); j++) {
                    if (tmap[kill[i][0]].get(j) == kill[i][1]) {
                        cnt++;
                        tmap[kill[i][0]].remove(j);
                    }
                }
            }
        }
        return cnt;
    }

    static boolean nextPermutation() {
        int i = M - 1;
        while (i > 0 && nplist[i-1] >= nplist[i]) --i;
        if (i == 0) return false;

        int j = M - 1;
        while (nplist[i-1] >= nplist[j]) --j;

        int temp = nplist[i-1];
        nplist[i-1] = nplist[j];
        nplist[j] = temp;

        j = M - 1;
        while(i < j) {
            temp = nplist[i];
            nplist[i++] = nplist[j];
            nplist[j--] = temp;
        }

        return true;
    }
}
