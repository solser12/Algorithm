package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {

    static int N, M;
    static int[][] cheese;
    static int[] di = {0, 0, 1, -1};
    static int[] dj = {1, -1, 0, 0};
    static int cnt = 0, time = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cheese = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
                if(cheese[i][j] == 1) cnt++;
            }
        }

        int check;
        while (true) {
            check = bfs(cnt);
            if (check == 0) break;
            time++;
            cnt = check;
        }

        System.out.println(time + "\n" + cnt);
        br.close();
    }

    static int bfs(int cnt) {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) temp[i] = cheese[i].clone();

        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(0, 0));
        temp[0][0] = -1;

        // -1 방문, 2 녹은 치즈 부분
        while(!q.isEmpty()) {
            Loc loc = q.poll();
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + di[d];
                int dy = loc.y + dj[d];
                if (dx >= 0 && dx < N && dy >= 0 && dy < M) {
                    if (temp[dx][dy] == 1) {        // 치즈 녹을 때
                        temp[dx][dy] = 2;
                        cnt--;
                        cheese[dx][dy] = 0;
                    }
                    else if (temp[dx][dy] == 0) {
                        q.add(new Loc(dx, dy));
                        temp[dx][dy] = -1;
                    }
                }
            }
        }

        return cnt;
    }

    static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
