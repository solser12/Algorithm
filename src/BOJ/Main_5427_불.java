package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5427_불 {

    public static int w, h;
    public static char[][] building;
    public static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            building = new char[h][w];

            Loc start = null;
            ArrayList<Loc> fireStart = new ArrayList<>();
            for (int i = 0; i < h; i++) {
                String input = br.readLine();
                for (int j = 0; j < w; j++) {
                    char c = input.charAt(j);
                    building[i][j] = c;
                    if (c == '@') {
                        start = new Loc(i, j);
                    } else if (c == '*') {
                        fireStart.add(new Loc(i, j));
                    }
                }
            }

            int result = bfs(start, fireStart);
            sb.append(result < 0 ? "IMPOSSIBLE" : result).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static int bfs(Loc start, ArrayList<Loc> fireStart) {

        Queue<Loc> sanggeun = new LinkedList<>();
        Queue<Loc> fire = new LinkedList<>(fireStart);
        sanggeun.offer(start);

        int time = 1;
        while (!sanggeun.isEmpty()) {

            int size = fire.size();
            for (int s = 0; s < size; s++) {
                Loc now = fire.poll();
                for (int d = 0; d < 4; d++) {
                    int dx = now.x + dt[d][0];
                    int dy = now.y + dt[d][1];
                    if (check(dx, dy) && (building[dx][dy] == '.' || building[dx][dy] == '@')) {
                        fire.offer(new Loc(dx, dy));
                        building[dx][dy] = '*';
                    }
                }
            }

            size = sanggeun.size();
            for (int s = 0; s < size; s++) {
                Loc now = sanggeun.poll();
                for (int d = 0; d < 4; d++) {
                    int dx = now.x + dt[d][0];
                    int dy = now.y + dt[d][1];
                    if (!check(dx, dy)) {
                        return time;
                    } else if (building[dx][dy] == '.') {
                        sanggeun.offer(new Loc(dx, dy));
                        building[dx][dy] = '@';
                    }
                }
            }

            time++;
        }

        return -1;
    }

    public static boolean check(int x, int y) {
        return 0 <= x && x < h && 0 <= y && y < w;
    }

    public static class Loc {

        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}