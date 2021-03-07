package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2564_경비원 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int ans = 0;

        int T = Integer.parseInt(br.readLine());
        loc[] shop = new loc[T+1];

        for (int i = 0; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int way = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            int x, y;
            if (way == 1) { x = 0; y = dist; }
            else if (way == 2) { x = M; y = dist; }
            else if (way == 3) { x = dist; y = 0; }
            else { x = dist; y = N; }
            shop[i] = new loc(x, y, way);
        }

        int dx = shop[T].x;
        int dy = shop[T].y;
        int dw = shop[T].way;

        for (int i = 0; i < T; i++) {
            int sx = shop[i].x;
            int sy = shop[i].y;
            int sw = shop[i].way;

            System.out.println(dx + " " + dy);
            System.out.println(sx + " " + sy);
            if (dw == sw) ans += Math.abs(dw) == 1 ? Math.abs(dy - sy) : Math.abs(dx - sx);
            else if (dw == sw*(-1)) {
                if (Math.abs(dw) == 1) ans += (dy + sy <= N ? dy + sy : N * 2 - (dy + sy)) + M;
                else ans += (dx + sx <= M ? dx + sx : M * 2 - (dx + sx)) + N;
            }
            else ans += Math.abs(dx - sx) + Math.abs(dy - sy);
        }

        System.out.println(ans);
        br.close();
    }

    static class loc {
        int x, y, way;

        public loc(int x, int y, int way) {
            this.x = x;
            this.y = y;
            if (way == 2) this.way = -1;
            else if (way == 3) this.way = 2;
            else if (way == 4) this.way = -2;
            else this.way = 1;
        }
    }
}
