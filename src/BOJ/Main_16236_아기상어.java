package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16236_아기상어 {

    static int N, sharkSize = 2, sharkEat = 0, time = 0;
    static int[][] map;
    static Loc sharkLoc;

    static int[] d = {-1, 0, 0, -1, 0, 1, 1, 0};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) sharkLoc = new Loc(i, j);
            }
        }

        // 먹잇감 찾기
        while(bfs()) {};

        System.out.println(time);
        br.close();
    }

    static boolean bfs() {
        int[][] visit  = new int[N][N];
        Queue<Loc> q = new LinkedList<>();
        int cnt = 1;
        boolean check = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 || map[i][j] == 9 || map[i][j] == sharkSize) {
                    visit[i][j] = 0;    // 지나갈 수 있는 곳
                }
                else if (map[i][j] < sharkSize){
                    check = true;
                    visit[i][j] = 1;    // 먹을 수 있는 물고기
                }
                else {
                    visit[i][j] = -1;   // 못지나가는 곳
                }
            }
        }

        /**   0 1 2 3 4 5
         *
         *    3
         * 0  5 4 9 0 3 4
         * 1  4 3 0 3 4 5
         * 2  3 2 0 5 6 6
         * 3  2 0 0 3 4 5
         * 4  3 2 0 6 5 4
         * 5  6 6 6 6 6 6
         */

        if (!check) return false;

        q.add(sharkLoc);
        visit[sharkLoc.x][sharkLoc.y] = -1;

        while(!q.isEmpty()) {
            int size = q.size();
            ArrayList<Loc> find = new ArrayList<>();
            for (int s = 0; s < size; s++) {
                Loc loc = q.poll();
                for (int i = 0; i < d.length; i+=2) {
                    int dx = loc.x + d[i];
                    int dy = loc.y + d[i+1];
                    if (dx >= 0 && dx < N && dy >= 0 && dy < N && visit[dx][dy] >= 0) {
                        if (visit[dx][dy] == 1) {
                            find.add(new Loc(dx, dy));
                        }
                        else {
                            q.add(new Loc(dx, dy));
                            visit[dx][dy] = -1;
                        }
                    }
                }
            }
            if (find.size() > 0) {
                Collections.sort(find);
                int dx = find.get(0).x;
                int dy = find.get(0).y;
                map[dx][dy] = 0;
                map[sharkLoc.x][sharkLoc.y] = 0;
                sharkLoc.x = dx;
                sharkLoc.y = dy;
//                System.out.println("EAT : " + dx + " " + dy);
                sharkEat++;
                if (sharkSize == sharkEat) {
                    sharkSize++;
                    sharkEat = 0;
                }
                time += cnt;
                return true;
            }
            cnt++;
        }

        return false;
    }

    static class Loc implements Comparable<Loc> {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Loc o) {
            if (this.x < o.x) return -1;
            else if (this.x > o.x) return 1;
            else {
                if (this.y < o.y) return -1;
                else return 1;
            }
        }
    }
}
