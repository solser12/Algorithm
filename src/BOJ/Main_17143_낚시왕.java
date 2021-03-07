package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17143_낚시왕 {

    static int R, C, M, scnt, totalSize = 0;
    static int[][] map, tempMap;
    static Shark[] sharks;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = scnt = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        sharks = new Shark[M+1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int speed = Integer.parseInt(st.nextToken());
            int way = Integer.parseInt(st.nextToken());
            int size  = Integer.parseInt(st.nextToken());

            map[r][c] = i;
            sharks[i] = new Shark(new Loc(r, c), speed, way, size, i);
        }

        for (int i = 0; i < C; i++) {
            // 잡을 수 있는 상어 찾기
            catchShark(i);

            // 상어가 없으면 break
            if (scnt == 0) break;

            // 임시맵 생성
            tempMap = new int[R][C];
            for (int j = 1; j <= M; j++) {
                if (sharks[j] == null) continue;
                // 상어 이동 시키기
                sharks[j].moveShark();
            }

            // 임시맵 복사
            for (int j = 0; j < R; j++) {
                map[j] = tempMap[j].clone();
            }
        }

        System.out.println(totalSize);
        br.close();
    }

    static void catchShark(int loc) {
        for (int i = 0; i < R; i++) {
            if (map[i][loc] != 0) {
                // 상어를 잡음
                totalSize += sharks[map[i][loc]].size;
                sharks[map[i][loc]] = null;
                map[i][loc] = 0;
                scnt--;
                return;
            }
        }
    }

    static class Shark {
        Loc loc;
        // 1 위, -1 아래, 2 왼쪽, -2 오른쪽
        int speed, way, size, idx;

        public Shark(Loc loc, int speed, int way, int size, int idx) {
            this.loc = loc;
            this.speed = speed;
            if (way == 1) this.way = 1;
            else if (way == 2) this.way = -1;
            else if (way == 3) this.way = -2;
            else this.way = 2;
            this.size = size;
            this.idx = idx;
        }

        public void moveShark() {
//            System.out.println("기존 위치(" + idx + ") : " + loc.x + " " + loc.y);
//            System.out.println("스피드 : " + speed);
//            System.out.println("방향 : " +  (way == 1 ? "상" : (way == -1 ? "하" : (way == 2 ? "좌" : "우"))));

            int temp, cycle, step, rc;

            if (way == 1 || way == -1) {
                temp = loc.x;
                rc = R - 1;
            }
            else {
                temp = loc.y;
                rc = C - 1;
            }

            if (way > 0) {
                temp = rc - temp + speed;
                cycle = temp / rc;
                step = temp % rc;
                if (cycle % 2 == 0) {
                    if (way == 1) loc.x = rc - step;
                    else loc.y = rc - step;
                }
                else {
                    if (way == 1) loc.x = step;
                    else loc.y = step;
                    way *= -1;
                }
            }
            else {
                temp = temp + speed;
                cycle = temp / rc;
                step = temp % rc;
                if (cycle % 2 == 0) {
                    if (way == -1) loc.x = step;
                    else loc.y = step;
                }
                else {
                    if (way == -1) loc.x = rc - step;
                    else loc.y = rc - step;
                    way *= -1;
                }
            }

//            System.out.println("이동한 위치(" + "방향 : " +  (way == 1 ? "상" : (way == -1 ? "하" : (way == 2 ? "좌" : "우"))) + ") : "  +loc.x + " " + loc.y);
//            System.out.println();
            if (tempMap[loc.x][loc.y] == 0) tempMap[loc.x][loc.y] = idx;
            else checkSize(loc.x, loc.y, tempMap[loc.x][loc.y], idx);
        }
    }

    static void checkSize(int x, int y, int idx1, int idx2) {
        int size1, size2;
        size1 = sharks[idx1].size;
        size2 = sharks[idx2].size;
        if (size1 > size2) {
            sharks[idx2] = null;
        }
        else {
            sharks[idx1] = null;
            tempMap[x][y] = idx2;
        }
        scnt--;
    }

    static class Loc {
        int x, y;
        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
