package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15684_사다리조작 {

    static int N, M, H, maxCnt;
    static boolean[][] ladder;
    static boolean isFind = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        ladder = new boolean[H][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            ladder[row][col] = true;
        }

        for (maxCnt = 0; maxCnt < 4; maxCnt++) {
            start(0, new Loc(0, 0));
            if (isFind) break;
        }

        System.out.println(isFind ? maxCnt : -1);
        br.close();
    }

    static void start(int cnt, Loc loc) {

        if (isFind) {
            return;
        } else if (cnt == maxCnt) {    // 만약 사다리를 다 놓았으면 확인하기
            // 확인하기
            isFind = check();
            return;
        } else if (loc.x == -1 && loc.y == -1) {  // 위치 확인을 끝 까지 했을 때
            // 목표 사다리 못채웠으므로 return
            return;
        }

        // 내 자리에 사다리를 놓을 수 있나 확인
        // 1. 이미 놓아져 있는지 확인
        if (!ladder[loc.x][loc.y]) {
            // 2. 왼쪽 놓아져 있는지 확인
            if (loc.y == 0 || (loc.y - 1 >= 0 && !ladder[loc.x][loc.y - 1])) {
                // 3. 오른쪽에 놓아져 있는지 확인
                if (loc.y == N - 1 || (loc.y + 1 < N && !ladder[loc.x][loc.y + 1])) {
                    // 사다리 놓고
                    ladder[loc.x][loc.y] = true;
                    // 다음으로 넘기기
                    start(cnt + 1, loc.next());
                    // 놓았던 사다리 없애기
                    ladder[loc.x][loc.y] = false;
                }
            }
        }

        if (isFind) return;

        // 그냥 넘어가기
        start(cnt, loc.next());
    }

    static boolean check() {
        int checkCnt = 0;
        // 전부 확인하기
        for (int s = 0; s < N; s++) {
            int start = s;
            // 하나씩 내려가기
            for (int i = 0; i < H; i++) {
                // 왼쪽으로 이동하기
                if (start != 0 && ladder[i][start - 1]) {
                    start--;
                } else if (ladder[i][start]) {    // 오른쪽으로 이동하기
                    start++;
                }
            }
            if (start == s) checkCnt++;
        }

        return checkCnt == N;
    }

    static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Loc next() {
            int dx = x;
            int dy = y;

            // 가로 넘었을 때
            if (y + 1 >= N - 1) {
                // 세로도 넘었을 때
                if (x + 1 >= H) {
                    dx = -1;
                    dy = -1;
                } else {
                    dx++;
                    dy = 0;
                }
            } else {
                dy++;
            }

            return new Loc(dx, dy);
        }
    }
}
