package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_8972_미친아두이노 {

    static int[][] dt = {{}, {1, -1}, {1, 0}, {1, 1}, {0, -1} ,{0, 0} ,{0, 1} ,{-1, -1} ,{-1, 0} ,{-1, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Jongsu jongsu = null;
        ArrayList<Crazy> crazy = new ArrayList<Crazy>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int crazyCnt = 0;
        int[][] map = new int[R][C];
        char[][] result = new char[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = s.charAt(j);

                if (c == 'I') {
                    jongsu = new Jongsu(i, j);
                } else if (c == 'R') {
                    crazy.add(new Crazy(i, j));
                    crazyCnt++;
                }

                map[i][j] = -1;
                result[i][j] = '.';
            }
        }

        Stack<Crazy> recover = new Stack<>();
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            int order = s.charAt(i) - '0';

            // 종수 이동시키기
            jongsu.move(order);

            // 아두이노 하나씩 이동
            for (int j = 0; j < crazy.size(); j++) {

                if (crazy.get(j) == null) continue;

                // 이동하면서 만났는지 확인
                if (crazy.get(j).move(jongsu.x, jongsu.y)) {
                    System.out.println("kraj " + (i + 1));
                    System.exit(0);
                }

                if (map[crazy.get(j).x][crazy.get(j).y] == -2) {
                    crazy.set(j, null);
                    crazyCnt--;
                } else if (map[crazy.get(j).x][crazy.get(j).y] > -1) {
                    crazy.set(map[crazy.get(j).x][crazy.get(j).y], null);
                    map[crazy.get(j).x][crazy.get(j).y] = -2;
                    crazy.set(j, null);
                    crazyCnt -= 2;
                } else {
                    map[crazy.get(j).x][crazy.get(j).y] = j;
                    recover.push(crazy.get(j));
                }
            }

            while (!recover.isEmpty()) {
                Crazy pop = recover.pop();
                map[pop.x][pop.y] = -1;
            }
        }

        result[jongsu.x][jongsu.y] = 'I';
        for (Crazy c : crazy) {
            if (c == null) continue;
            result[c.x][c.y] = 'R';
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(result[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static class Jongsu {
        int x, y;

        public Jongsu(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move(int way) {
            this.x += dt[way][0];
            this.y += dt[way][1];
        }
    }

    public static class Crazy {
        int x, y;

        public Crazy(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean move(int x, int y) {
            int dx = this.x - x;
            int dy = this.y - y;
            int way;

            if (dx == 0) {
                if (dy > 0) way = 4;
                else if (dy < 0) way = 6;
                else way = 5;
            } else if (dx > 0) {
                if (dy == 0) way = 8;
                else if (dy > 0) way = 7;
                else way = 9;
            } else {
                if (dy == 0) way = 2;
                else if (dy > 0) way = 1;
                else way = 3;
            }

            this.x += dt[way][0];
            this.y += dt[way][1];

            if (this.x == x && this.y == y) {
                return true;
            }

            return false;
        }
    }
}
