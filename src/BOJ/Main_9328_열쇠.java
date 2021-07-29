package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_9328_열쇠 {

    static char[][] map;
    static int[][] visited;
    static int h, w, document, find, visitedCnt;
    static int[][] dt = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static ArrayList<Loc>[] keyLoc;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken()) + 2;
            w = Integer.parseInt(st.nextToken()) + 2;

            document = 0;
            find = 0;
            visitedCnt = 0;

            map = new char[h][w];
            visited = new int[h][w];
            for (int i = 0; i < h; i++) {
                Arrays.fill(map[i], '.');
                Arrays.fill(visited[i], -1);
            }

            keyLoc = new ArrayList[26];
            for (int i = 0; i < 26; i++) keyLoc[i] = new ArrayList<>();

            for (int i = 1; i < h - 1; i++) {
                String input = br.readLine();
                for (int j = 1; j < w - 1; j++) {
                    char c = input.charAt(j - 1);
                    map[i][j] = c;

                    // 문 위치 저장
                    if (c >= 'A' && c <= 'Z') {
                        keyLoc[c - 'A'].add(new Loc(i, j));
                    }
                    if (c == '$') document++;
                }
            }

            // 열쇠로 미리 문열기
            String keys = br.readLine();
            if (!keys.equals("0")) {
                for (int i = 0; i < keys.length(); i++) {
                    char key = keys.charAt(i);
                    for (Loc loc : keyLoc[key - 'a']) {
                        map[loc.x][loc.y] = '.';
                    }
                }
            }

            bfs();

            sb.append(find).append('\n');
        }
        System.out.println(sb);
        br.close();
    }

    public static void bfs() {

        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(0, 0));
        visited[0][0] = visitedCnt;

        while (!q.isEmpty()) {
            Loc loc = q.poll();

            if (map[loc.x][loc.y] >= 'a' && map[loc.x][loc.y] <= 'z') {
                // 열쇠를 얻으면
                if (keyLoc[map[loc.x][loc.y] - 'a'].size() > 0) {
                    visitedCnt++;
                    q.clear();
                    q.add(new Loc(0, 0));
                    visited[0][0] = visitedCnt;
                    for (Loc key : keyLoc[map[loc.x][loc.y] - 'a']) {
                        map[key.x][key.y] = '.';
                    }
                    map[loc.x][loc.y] = '.';
                    continue;
                } else {
                    map[loc.x][loc.y] = '.';
                }
            } else if (map[loc.x][loc.y] == '$') {
                // 문서를 얻으면
                map[loc.x][loc.y] = '.';
                find++;
                if (document == find) return;
            }

            for (int d = 0; d < 4; d++) {
                int dx = loc.x + dt[d][0];
                int dy = loc.y + dt[d][1];
                if (dx >= 0 && dx < h && dy >= 0 && dy < w && visited[dx][dy] < visitedCnt
                        && (map[dx][dy] == '$' || map[dx][dy] == '.' || (map[dx][dy] >= 'a' && map[dx][dy] <= 'z'))) {
                    visited[dx][dy] = visitedCnt;
                    q.add(new Loc(dx, dy));
                }
            }
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
