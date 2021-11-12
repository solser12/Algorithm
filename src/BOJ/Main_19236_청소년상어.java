package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19236_청소년상어 {

    public static int ans = 0;
    public static int[][] dt = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[4][4];
        Fish[] fish = new Fish[16];

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken()) - 1;
                int way = Integer.parseInt(st.nextToken()) - 1;
                map[i][j] = num;
                fish[num] = new Fish(new Loc(i, j), num, way);
            }
        }

        Fish shark = new Fish(new Loc(0, 0), map[0][0] + 1, fish[map[0][0]].way);
        fish[map[0][0]] = null;
        map[0][0] = -1;

        dfs(shark, fish, map);

        System.out.println(ans);
        br.close();
    }

    public static void dfs(Fish shark, Fish[] fish, int[][] map) {

        fishMove(map, fish);

        boolean isEat = false;
        int dx = shark.loc.x;
        int dy = shark.loc.y;
        while (true) {
            dx += dt[shark.way][0];
            dy += dt[shark.way][1];

            if (check(dx, dy)) {
                if (map[dx][dy] != -2) {
                    isEat = true;

                    int[][] mapTemp = new int[4][];
                    for (int i = 0; i < 4; i++) {
                        mapTemp[i] = map[i].clone();
                    }
                    Fish[] fishTemp = new Fish[16];
                    for (int i = 0; i < 16; i++) {
                        if (fish[i] == null) fishTemp[i] = null;
                        else fishTemp[i] = new Fish(new Loc(fish[i].loc.x, fish[i].loc.y), fish[i].num, fish[i].way);
                    }

                    Fish newShark = new Fish(new Loc(dx, dy), shark.num + map[dx][dy] + 1, fishTemp[map[dx][dy]].way);
                    fishTemp[mapTemp[dx][dy]] = null;
                    mapTemp[shark.loc.x][shark.loc.y] = -2;
                    mapTemp[dx][dy] = -1;

                    dfs(newShark, fishTemp, mapTemp);
                }
            } else {
                break;
            }
        }

        if (!isEat) {
            ans = Math.max(ans, shark.num);
        }
    }

    public static void fishMove(int[][] map, Fish[] fish) {

        for (Fish f : fish) {
            if (f == null) continue;

            int dx, dy;
            while (true) {
                dx = f.loc.x + dt[f.way][0];
                dy = f.loc.y + dt[f.way][1];

                if (check(dx, dy) && map[dx][dy] != -1) {
                    break;
                }

                f.rotate();
            }

            if (map[dx][dy] != -2) {
                Loc temp = fish[map[dx][dy]].loc;

                map[f.loc.x][f.loc.y] = map[dx][dy];

                fish[map[dx][dy]].move(f.loc);
                f.move(temp);

                map[dx][dy] = f.num;
            } else {
                map[f.loc.x][f.loc.y] = -2;
                map[dx][dy] = f.num;
                f.move(dx, dy);
            }
        }
    }

    public static class Fish {
        Loc loc;
        int num, way;

        public Fish(Loc loc, int num, int way) {
            this.loc = loc;
            this.num = num;
            this.way = way;
        }

        public void rotate() {
            way++;
            way %= 8;
        }

        public void move(int x, int y) {
            loc.x = x;
            loc.y = y;
        }

        public void move(Loc loc) {
            this.loc = loc;
        }
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean check(int x, int y) {
        return x >= 0 && x < 4 && y >= 0 && y < 4;
    }
}
