package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1388_바닥_장식 {

    public static int n, m;
    public static char[][] floor;
    public static HashMap<Character, int[]> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map.put('-', new int[] {0, 1});
        map.put('|', new int[] {1, 0});

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        floor = new char[n][];
        for (int i = 0; i < n; i++) {
            floor[i] = br.readLine().toCharArray();
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (floor[i][j] != 'x') {
                    bfs(i, j, floor[i][j]);
                    ans++;
                }
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static void bfs(int x, int y, char type) {

        int[] dt = map.get(type);
        Queue<Loc> q = new LinkedList<>();
        q.offer(new Loc(x, y));
        floor[x][y] = 'x';

        while (!q.isEmpty()) {
            Loc loc = q.poll();
            int dx = loc.x + dt[0];
            int dy = loc.y + dt[1];
            if (check(dx, dy, type)) {
                floor[dx][dy] = 'x';
                q.offer(new Loc(dx, dy));
            }
        }
    }

    public static boolean check(int x, int y, char type) {
        return 0 <= x && x < n && 0 <= y && y < m && floor[x][y] == type;
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
