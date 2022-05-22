package Programmers;

public class 행렬테두리회전하기 {

    public int[] solution(int rows, int columns, int[][] queries) {

        int[] ans = new int[queries.length];
        Table table = new Table(rows, columns);
        for (int i = 0; i < queries.length; i++) {
            ans[i] = table.rotate(queries[i][0] - 1, queries[i][1] - 1, queries[i][2] - 1, queries[i][3] - 1);
        }

        return ans;
    }

    public class Table {

        int r, c;
        int[][] table;
        int[][] dt = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public Table(int r, int c) {
            this.r = r;
            this.c = c;
            this.table = new int[r][c];
            int num = 1;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    table[i][j] = num++;
                }
            }
        }

        public int rotate(int x1, int y1, int x2, int y2) {

            Loc now = new Loc(x1, y1);

            int nextNum = table[x1][y1];
            int result = nextNum;

            int totalCnt = (x2 - x1 + 1) * (y2 - y1 + 1) - Math.max((x2 - x1 - 1) * (y2 - y1 - 1), 0);
            for (int i = 0; i < totalCnt; i++) {
                next(now, x1, y1, x2, y2);
                int temp = table[now.x][now.y];
                table[now.x][now.y] = nextNum;
                nextNum = temp;

                result = Math.min(result, nextNum);
            }

            return result;
        }

        public void next(Loc loc, int x1, int y1, int x2, int y2) {

            if ((loc.way == 0 && loc.y == y2) || (loc.way == 1 && loc.x == x2) || (loc.way == 2 && loc.y == y1)) {
                loc.way++;
            }

            loc.x += dt[loc.way][0];
            loc.y += dt[loc.way][1];
        }
    }

    public class Loc {

        int x, y, way;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
            this.way = 0;
        }
    }
}
