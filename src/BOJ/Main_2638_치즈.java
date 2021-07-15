package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2638_치즈 {

    static int N, M, size = 0, time = 0;
    static int[][] paper, visited;
    static int[][] dt = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static Queue<Loc> q = new LinkedList<>();
    static Queue<Loc> delete = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
                if (paper[i][j] == 1) size++;
            }
        }

        while(size != 0) {
            melt();
            time++;
        }

        System.out.println(time);
        br.close();
    }

    public static void melt() {

        for (int i = 0; i < N; i++) Arrays.fill(visited[i], 0);

        q.add(new Loc(0 ,0));
        while (!q.isEmpty()) {
            Loc loc = q.poll();
            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];

                if (dx >= 0 && dx < N && dy >= 0 && dy < M && visited[dx][dy] != -1) {
                    if (visited[dx][dy] == 0) {
                        if (paper[dx][dy] == 0) {
                            q.add(new Loc(dx, dy));
                            visited[dx][dy] = -1;
                        }
                        else {
                            visited[dx][dy]++;
                        }
                    } else if (visited[dx][dy] == 1) {
                        visited[dx][dy]++;
                        if (visited[dx][dy] == 2) {
                            delete.add(new Loc(dx, dy));
                        }
                    }
                }
            }
        }

        while (!delete.isEmpty()) {
            Loc loc = delete.poll();
            paper[loc.x][loc.y] = 0;
            size--;
        }
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
