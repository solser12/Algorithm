package BOJ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2589_보물섬 {

    static int N, M;
    static char[][] map, cpmap;
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int max = 0;
        map = new char[N][];
        cpmap = new char[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            map[i] = input.toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    int result = bfs(i, j);
                    max = Math.max(result, max);
                }
            }
        }

        System.out.println(max);
        br.close();
    }

    public static int bfs(int x, int y) {
        for(int i = 0; i < N; i++) cpmap[i] = map[i].clone();
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(x, y));
        cpmap[x][y] = 'W';
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            Loc l = q.peek();
            for (int s = 0; s < size; s++) {
                Loc loc = q.poll();
                for (int d = 0; d < 4; d++) {
                    int dx = loc.x + di[d];
                    int dy = loc.y + dj[d];
                    if (dx >= 0 && dx < N && dy >= 0 && dy < M && cpmap[dx][dy] == 'L') {
                        cpmap[dx][dy] = 'W';
                        q.add(new Loc(dx, dy));
                    }
                }
            }
            time++;
        }
        return time - 1;
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
