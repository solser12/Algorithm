package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_달이_차오른다_가자 {

    static int N, M, step = 1;
    static char[][] map;
    static boolean[][][] visit;
    static Loc start;
    static int[] di = {0 ,0, 1, -1};
    static int[] dj = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[64][N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == '0') {
                    start = new Loc(i, j, 0);
                }
            }
        }

        bfs();

        System.out.println(step);
        br.close();
    }

    static void bfs() {
        Queue<Loc> q = new LinkedList<>();
        q.add(start);
        visit[start.item][start.x][start.y] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Loc loc = q.poll();
                int x = loc.x;
                int y = loc.y;
                int item = loc.item;
                int newItem = item;
                for (int d = 0; d < 4; d++) {
                    int dx = x + di[d];
                    int dy = y + dj[d];
                    if (dx >= 0 && dx < N && dy >= 0 && dy < M && !visit[item][dx][dy]) {
                        if(map[dx][dy] == '#') {                                // 벽을 만났을 때
                            continue;
                        }
                        else if (map[dx][dy] >= 'a' && map[dx][dy] <= 'f') {    // 아이템을 발견했을 때
                            int shift = map[dx][dy] - 'a';
                            newItem |= (1 << shift);
                            visit[item][dx][dy] = true;
                            q.add(new Loc(dx, dy, newItem));
                            continue;
                        }
                        else if (map[dx][dy] >= 'A' && map[dx][dy] <= 'F') {    // 문을 만났을 때
                            int door = map[dx][dy] - 'A';
                            if ((item & (1 << door)) == 0) {
                                continue;
                            }
                        }
                        else if (map[dx][dy] == '1') {                          // 출구를 만났을 때
                            return;
                        }
//                        System.out.println(step + " ["+ dx +" , " + dy + "] " + item);
                        // 빈곳을 갔을 때(아이템 + 문)
                        visit[item][dx][dy] = true;
                        q.add(new Loc(dx, dy, item));
                    }
                }
            }
            step++;
        }
        step = -1;
    }

    static class Loc {
        int x, y, item;

        public Loc(int x, int y, int item) {
            this.x = x;
            this.y = y;
            this.item = item;
        }
    }
}