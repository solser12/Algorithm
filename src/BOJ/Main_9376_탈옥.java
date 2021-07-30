package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_9376_탈옥 {
    
    static int h, w;
    static char[][] map;
    static int[][] count;
    static int[][] dt = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h + 2][w + 2];
            count = new int[h + 2][w + 2];
            for (int i = 0; i < h + 2; i++) {
                Arrays.fill(map[i], '.');
                Arrays.fill(count[i], -1);
            }

            Loc prisoner1 = null, prisoner2 = null;
            Loc sang = new Loc(0, 0, 0);
            for (int i = 1; i <= h; i++) {
                String input = br.readLine();
                for (int j = 0; j < w; j++) {
                    char data = input.charAt(j);
                    map[i][j + 1] = data;
                    if (data == '$') {
                        if (prisoner1 == null) {
                            prisoner1 = new Loc(i, j + 1, 0);
                        } else {
                            prisoner2 = new Loc(i, j + 1, 0);
                        }
                        map[i][j + 1] = '.';
                    } else if (data == '*') {
                        count[i][j + 1] = Integer.MAX_VALUE;
                    }
                }
            }


            bfs(sang);
            bfs(prisoner1);
            bfs(prisoner2);

            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < h + 2; i++) {
                for (int j = 0; j < w + 2; j++) {
                    int cnt = count[i][j];
                    if (cnt == -1) continue;
                    if (map[i][j] == '#') cnt -= 2;
                    ans = Math.min(ans, cnt);
                }
            }

            sb.append(ans).append('\n');

//            for (int[] ints : count) {
//                for (int i : ints) {
//                    System.out.print((i == Integer.MAX_VALUE ? "-" : i) + "\t");
//                }
//                System.out.println();
//            }
        }

        System.out.println(sb);
        br.close();
    }

    public static void bfs(Loc start) {

        boolean[][] visited = new boolean[h + 2][w + 2];

        Deque<Loc> dq = new LinkedList<>();
        dq.add(start);
        visited[start.x][start.y] = true;

        while (!dq.isEmpty()) {
            Loc loc = dq.poll();

            if (count[loc.x][loc.y] == -1) count[loc.x][loc.y] = 0;
            count[loc.x][loc.y] += loc.door;

            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];

                if (dx >= 0 && dx < h + 2 && dy >= 0 && dy < w + 2 && !visited[dx][dy] && map[dx][dy] != '*') {
                    visited[dx][dy] = true;
                    if (map[dx][dy] == '#') {
                        dq.addLast(new Loc(dx, dy, loc.door + 1));
                    } else {
                        dq.addFirst(new Loc(dx, dy, loc.door));
                    }
                }
            }
        }
    }


    public static class Loc implements Comparable<Loc> {
        int x, y, door;

        public Loc(int x, int y, int door) {
            this.x = x;
            this.y = y;
            this.door = door;
        }

        @Override
        public int compareTo(Loc o) {
            return this.door - o.door;
        }
    }
}
