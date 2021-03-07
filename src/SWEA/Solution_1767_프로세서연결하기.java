package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기 {

    static int N, wire, count;
    static int[][] cpu;
    static ArrayList<Core> cores;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer  st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            N = Integer.parseInt(br.readLine());
            cpu = new int[N][N];
            cores = new ArrayList<>();
            wire = Integer.MAX_VALUE;
            count = 0;

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cpu[i][j] = Integer.parseInt(st.nextToken());
                    if (cpu[i][j] == 1 && i != 0 && i != N-1 && j != 0 && j != N-1) cores.add(new Core(i, j));
                }
            }

            dfs(0, 0, 0);

            sb.append('#').append(t).append(' ').append(wire).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

    static void dfs(int cnt, int finish, int total) {

        if (finish + (cores.size() - cnt) < count) return;

        if (cnt == cores.size()) {
            if (finish > count) {
                count = finish;
                wire = total;
            }
            else if (finish == count) {
                wire = Math.min(wire, total);
            }
            return;
        }

        Core core = cores.get(cnt);

        // 위
        for (int i = core.x - 1; i >= 0; i--) {
            if (cpu[i][core.y] != 0) {
                for (int j = core.x - 1; j > i; j--) cpu[j][core.y] = 0;
                break;
            }
            cpu[i][core.y] = 2;
            if (i == 0) {
                dfs(cnt+1, finish+1, total+core.x);
                for (int j = core.x - 1; j >= 0; j--) cpu[j][core.y] = 0;
            }
        }

        // 아래
        for (int i = core.x + 1; i < N; i++) {
            if (cpu[i][core.y] != 0) {
                for (int j = core.x + 1; j < i; j++) cpu[j][core.y] = 0;
                break;
            }
            cpu[i][core.y] = 2;
            if (i == N-1) {
                dfs(cnt+1, finish+1, total+(N-core.x-1));
                for (int j = core.x + 1; j < N; j++) cpu[j][core.y] = 0;
            }
        }

        // 왼쪽
        for (int i = core.y - 1; i >= 0; i--) {
            if (cpu[core.x][i] != 0) {
                for (int j = core.y - 1; j > i; j--) cpu[core.x][j] = 0;
                break;
            }
            cpu[core.x][i] = 2;
            if (i == 0) {
                dfs(cnt+1, finish+1, total+core.y);
                for (int j = core.y - 1; j >= 0; j--) cpu[core.x][j] = 0;
            }
        }

        // 오른쪽
        for (int i = core.y + 1; i < N; i++) {
            if (cpu[core.x][i] != 0) {
                for (int j = core.y + 1; j < i; j++) cpu[core.x][j] = 0;
                break;
            }
            cpu[core.x][i] = 2;
            if (i == N-1) {
                dfs(cnt+1, finish+1, total+(N-core.y-1));
                for (int j = core.y + 1; j < N; j++) cpu[core.x][j] = 0;
            }
        }

        // 연결 안 할 때
        dfs(cnt+1, finish, total);
    }

    static class Core {
        int x, y;

        public Core(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
