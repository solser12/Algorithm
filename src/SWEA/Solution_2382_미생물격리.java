package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2382_미생물격리 {

    static int N, M, K;
    static Loc[][] map;
    static Micro[] micro;
    static int microLoc;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());       // 크기
            M = Integer.parseInt(st.nextToken());       // 시간
            K = Integer.parseInt(st.nextToken());       // 미샘물 수
            int ans = 0;
            micro = new Micro[K+1];
            map = new Loc[N][N];
            for (int i = 1; i <= K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int way = Integer.parseInt(st.nextToken());
                if (way == 2) way = -1;
                else if (way == 3) way = 2;
                else if (way == 4) way = -2;
                micro[i] = new Micro(x, y, num, way);
            }

            for (int i = 0; i < M; i++) {
                for (microLoc = 1; microLoc <= K; microLoc++) micro[microLoc].move();
//                System.out.println("======================");
//                for (Loc[] a : map) {
//                    for (Loc b : a) {
//                        System.out.print((b == null ? 0 : micro[b.loc].num) + "\t");
//                    }
//                    System.out.println();
//                }
                for (int m = 0; m < N; m++) {
                    Arrays.fill(map[m], null);
                }
            }

            for (int i = 1; i <= K; i++) {
                ans += micro[i].num;

            }

            sb.append('#').append(t).append(' ').append(ans).append('\n');
        }

        System.out.print(sb.toString());
        br.close();
    }

    static class Micro {
        //  1상 -1하 2좌 -2우
        int x, y, num, way;

        public Micro(int x, int y, int num, int way) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.way = way;
        }

        public void move() {
            if (num == 0) return;
            if (way == 1) x--;
            else if (way == -1) x++;
            else if (way == 2) y--;
            else if (way == -2) y++;

            if (x == 0 || x == N-1 || y == 0 || y == N-1) {
                num /= 2;
                way *= -1;
            }

            checking();
        }

        public void checking() {
            Loc loc = map[x][y];

            if (loc == null) {
                map[x][y] = new Loc(microLoc, num);
                return;
            }

            if (loc.max < num) {
                map[x][y] = new Loc(microLoc, num);
                micro[microLoc].num += micro[loc.loc].num;
                micro[loc.loc].num = 0;
            }
            else {
                micro[loc.loc].num += num;
                num = 0;
            }
        }
    }

    static class Loc {
        int loc, max;

        public Loc(int loc, int max) {
            this.loc = loc;
            this.max = max;
        }
    }
}