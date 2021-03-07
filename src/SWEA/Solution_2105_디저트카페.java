package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2105_디저트카페 {

    static int N, ans;
    static int[][] map;
    static int[][] dir = {{1, 1, -1, -1}, {1, -1, -1, 1}};
    static boolean[] visit = new boolean[101];
    static ArrayList<Integer> step = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            N = Integer.parseInt(br.readLine());
            Arrays.fill(visit, false);
            step.clear();
            ans = -1;

            map = new int[N][N];
            for (int i = 0; i <  N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            step.add(2);
            for (int i = 0; i < N - 2; i++) {
                for (int j = 1; j < N - 1; j++) {
                    visit[map[i+1][j+1]] = true;
                    check(i + 1, j + 1, 0, 1);
                    visit[map[i+1][j+1]] = false;
                }
            }

            sb.append('#').append(t).append(' ').append(ans).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

    static void check(int x, int y, int way, int depth) {
        // 다시 돌아가기

        if (way == 1) {
            int dx = x, dy = y;
            boolean[] tempVisit = visit.clone();
            int size = step.size();
            for (int s = 0; s < size; s++) {
                dx += dir[0][step.get(s)];
                dy += dir[1][step.get(s)];
                if (dx >= 0 && dx < N && dy >= 0 && dy < N && !tempVisit[map[dx][dy]]) {
                    tempVisit[map[dx][dy]] = true;
                    if (s == size - 1) {
                        ans = Math.max(ans, depth * 2);
                    }
                    continue;
                }
                break;
            }
        }

        for (int i = 0; i < 2; i++) {
            if (way == 1 && i == 0) continue;
            int dx = x + dir[0][i];
            int dy = y + dir[1][i];
            if (dx >= 0 && dx < N && dy >= 0 && dy < N && !visit[map[dx][dy]]) {
                visit[map[dx][dy]] = true;
                step.add(i+2);
                check(dx, dy, i, depth + 1);
                visit[map[dx][dy]] = false;
                step.remove(step.size() - 1);
            }
        }
    }
}
