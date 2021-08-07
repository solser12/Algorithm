package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_18809_Gaaaaaaaaaarden {

    static int N, M, G, R, ans = 0;
    static int[][] map, tempMap;
    static ArrayList<Loc> possible = new ArrayList<>();
    static int[] perm;
    static int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        tempMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    possible.add(new Loc(i, j));
                    map[i][j] = 1;
                } else {
                    map[i][j] = num;
                }
            }
        }

        perm = new int[possible.size()];
        for (int i = 0; i < G; i++) {
            perm[possible.size() - 1 - i] = 3;
        }

        for (int i = G; i < R + G; i++) {
            perm[possible.size() - 1 - i] = 2;
        }

        do {
            for (int i = 0; i < N; i++) tempMap[i] = map[i].clone();
            bfs();
        } while (nextPermutation());

        System.out.println(ans);
        br.close();
    }

    public static void bfs() {

        Queue<Loc> q = new LinkedList<>();
        for (int i = 0; i < possible.size(); i++) {
            if (perm[i] == 2) {
                q.add(new Loc(possible.get(i).x, possible.get(i).y, false));
                tempMap[possible.get(i).x][possible.get(i).y] = 0;
            } else if (perm[i] == 3) {
                q.add(new Loc(possible.get(i).x, possible.get(i).y, true));
                tempMap[possible.get(i).x][possible.get(i).y] = 0;
            }
        }

        int flower = 0;
        Stack<Loc> change = new Stack<>();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Loc loc = q.poll();
                for (int d = 0; d < 4; d++) {
                    int dx = loc.x + dt[d][0];
                    int dy = loc.y + dt[d][1];
                    if (dx >= 0 && dx < N && dy >= 0 && dy < M && tempMap[dx][dy] > 0) {

                        if (tempMap[dx][dy] == 2) {
                            // 이미 그린이 있으면
                            if (loc.type) continue;

                            tempMap[dx][dy] = -1;
                            flower++;
                        } else if (tempMap[dx][dy] == 3) {
                            // 이미 레드가 있으면
                            if (!loc.type) continue;

                            tempMap[dx][dy] = -1;
                            flower++;
                        } else {
                            if (loc.type) {
                                tempMap[dx][dy] = 2;
                            } else {
                                tempMap[dx][dy] = 3;
                            }
                            change.push(new Loc(dx, dy, loc.type));
                        }
                    }
                }
            }

            while (!change.isEmpty()) {
                Loc loc = change.pop();
                if (tempMap[loc.x][loc.y] == -1) continue;
                tempMap[loc.x][loc.y] = 0;
                q.add(loc);
            }
        }

        ans = Math.max(flower, ans);
    }

    public static boolean nextPermutation() {

        int i = possible.size() - 1;
        while (i > 0 && perm[i-1] >= perm[i]) i--;
        if (i == 0) return false;

        int j = possible.size() - 1;
        while (perm[i-1] >= perm[j]) j--;

        int temp = perm[i-1];
        perm[i-1] = perm[j];
        perm[j] = temp;

        j = possible.size() - 1;
        while (i < j) {
            temp = perm[i];
            perm[i++] = perm[j];
            perm[j--] = temp;
        }

        return true;
    }

    public static class Loc {
        int x, y;
        boolean type;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Loc(int x, int y, boolean type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
