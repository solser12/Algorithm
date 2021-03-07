package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {

    static int N, W, H, ans;
    static int[][] map;
    static int[] checkZero;
    static int[] di = {0, 0, 1, -1};
    static int[] dj = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            int totalWall = 0;
            ans = Integer.MAX_VALUE;

            map = new int[H][W];
            checkZero = new int[W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] != 0) {
                        checkZero[j]++;
                        totalWall++;
                    }
                }
            }

            check(0, totalWall, map, checkZero);

            sb.append('#').append(t).append(' ').append(ans).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

    static void check(int cnt, int wallCnt, int[][] nowMap, int[] nowCheckZero) {

        if (ans == 0) return;
        else if (wallCnt == 0) {
            ans = 0;
            return;
        }

        if (cnt == N) {
            ans = Math.min(wallCnt, ans);
            return;
        }

        for (int i = 0; i < W; i++) {
             if (nowCheckZero[i] == 0) continue;
             if (ans == 0) return;
             // 임시생성
            int[][] myMap = new int[H][];
            for (int m = 0; m < H; m++) myMap[m] = nowMap[m].clone();
            int[] myCheckZero = nowCheckZero.clone();

            // 구슬 떨구기
            int myWallCnt =  wallCnt - dropBall(i , myMap ,myCheckZero);

            // 벽돌 내리기
            if (myWallCnt != wallCnt - 1) pushWall(myMap);

//            System.out.println("\n\n" +  i + "  ========================  " + cnt);
//            for (int a : myCheckZero) System.out.print(a + "\t");
//            System.out.println();
//            for (int[] a : myMap) {
//                for(int b : a) {
//                    System.out.print(b + "\t");
//                }
//                System.out.println();
//            }
//            System.out.println("@@@@@@@@@" + myWallCnt);

            check(cnt+1, myWallCnt, myMap, myCheckZero);
        }
    }

    static void pushWall(int[][] myMap) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < W; i++) {
            q.clear();
            for (int j = H-1; j >= 0; j--) {
                if (myMap[j][i] != 0) q.add(myMap[j][i]);
            }
            for (int j = H-1; j >= 0; j--) {
                if (!q.isEmpty()) myMap[j][i] = q.poll();
                else myMap[j][i] = 0;
            }
        }
    }

    static int dropBall(int y, int[][] myMap, int[] myCheckZero) {
        int cnt = 0;
        int x = 0;
        // 첫 번째 닿는 벽돌 찾기
        for (int i = 0; i < H; i++) {
            if (myMap[i][y] != 0) {
                x = i;
                break;
            }
        }

        // 연쇄반응 찾기
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(x, y, myMap[x][y]));
        myMap[x][y] = 0;
        myCheckZero[y]--;
        cnt++;

        while(!q.isEmpty()) {
            Loc loc = q.poll();
            for (int d = 0; d < 4; d++) {
                for (int r = 1; r < loc.range; r++) {
                    int dx = loc.x + di[d] * r;
                    int dy = loc.y + dj[d] * r;
                    if (dx >= 0 && dx < H && dy >= 0 && dy < W && myMap[dx][dy] != 0) {
                        q.add(new Loc(dx, dy, myMap[dx][dy]));
                        myMap[dx][dy] = 0;
                        myCheckZero[dy]--;
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    static class Loc {
        int x, y, range;

        public Loc(int x, int y, int range) {
            this.x = x;
            this.y = y;
            this.range = range;
        }
    }
}
