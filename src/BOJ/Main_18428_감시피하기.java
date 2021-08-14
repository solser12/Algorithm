package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_18428_감시피하기 {

    static int N;
    static char[][] map;
    static ArrayList<Loc> teacher;
    static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        teacher = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                char c = st.nextToken().charAt(0);
                if (c == 'T') {
                    teacher.add(new Loc(i, j));
                }
                map[i][j] = c;
            }
        }

        for (Loc loc : teacher) {
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (check(dx, dy) && map[dx][dy] == 'S') {
                    System.out.println("NO");
                    System.exit(0);
                }
            }
        }

        System.out.println(find(0, 0, 0) ? "YES" : "NO");
        br.close();
    }

    public static boolean find(int depth, int x, int y) {

        if (depth == 3) {
            for (Loc loc : teacher) {
                if (!loc.calc()) {
                    return false;
                }
            }
            return true;
        }

        int j = y;
        for (int i = x; i < N; i++) {
            while (j < N) {
                if (map[i][j] == 'X') {
                    map[i][j] = 'O';
                    if (find(depth + 1, i, j)) {
                        return true;
                    }
                    map[i][j] = 'X';
                }
                j++;
            }
            j = 0;
        }

        return false;
    }

    public static boolean check(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < N) return true;
        return false;
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean calc() {
            for (int d = 0; d < 4; d++) {
                int dx = x + dt[d][0];
                int dy = y + dt[d][1];
                while (check(dx, dy)) {

                    if (map[dx][dy] == 'S') {
                        return false;
                    } else if (map[dx][dy] != 'X') {
                        break;
                    }

                    dx += dt[d][0];
                    dy += dt[d][1];
                }
            }

            return true;
        }
    }
}
