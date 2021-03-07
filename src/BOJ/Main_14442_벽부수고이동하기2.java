package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_14442_벽부수고이동하기2 {

    static int N, M, K;
    static char[][] map;
    static List<int[][]> check;
    static Queue<Next> q = new LinkedList<>();
    static int[] dxy = {0, 1, 0, -1, 1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][];
        check = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            map[i] = input.toCharArray();
        }

        newMap();
        q.add(new Next(0, 0, 0));
        System.out.println(bfs());

        br.close();
    }

    static int bfs() {
        int step = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Next n = q.poll();
                if (n.x == N-1 && n.y == M-1) return step;
                for (int d = 0; d < dxy.length; d+=2) {
                    int dx = n.x + dxy[d];
                    int dy = n.y + dxy[d+1];
                    if (dx >= 0 && dx < N && dy >= 0 && dy < M) {
                        if (n.wall < K && map[dx][dy] == '1') {
                            if (n.wall >= check.size() - 1) newMap();
                            if (check.get(n.wall+1)[dx][dy] > check.get(n.wall)[n.x][n.y] + 1) {
                                check.get(n.wall+1)[dx][dy] = check.get(n.wall)[n.x][n.y] + 1;
                                q.add(new Next(dx, dy, n.wall + 1));
                            }
                        }
                        else if (map[dx][dy] == '0') {
                            if (check.get(n.wall)[dx][dy] > check.get(n.wall)[n.x][n.y] + 1) {
                                check.get(n.wall)[dx][dy] = check.get(n.wall)[n.x][n.y] + 1;
                                q.add(new Next(dx, dy, n.wall));
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    static void newMap() {
        int[][] nmap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                nmap[i][j] = Integer.MAX_VALUE;
            }
        }
        nmap[0][0] = 0;
        check.add(nmap);
    }

    static class Next {
        int x, y;
        int wall;

        public Next(int x, int y, int wall) {
            this.x = x;
            this.y = y;
            this.wall = wall;
        }
    }
}
