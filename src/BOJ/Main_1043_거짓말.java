package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1043_거짓말 {

    static int N, M, ans = 0;
    static ArrayList<Integer>[] order;
    static boolean[] know, visited;
    static boolean[][] member;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        know = new boolean[N + 1];
        visited = new boolean[N + 1];
        member = new boolean[N + 1][N + 1];
        order = new ArrayList[M];

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        for (int i = 0; i < num; i++) {
            int k = Integer.parseInt(st.nextToken());
            know[k] = true;
        }

        for (int i = 0; i < M; i++) {
            order[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            order[i].add(start);
            for (int j = 0; j < num - 1; j++) {
                int end = Integer.parseInt(st.nextToken());
                member[start][end] = true;
                member[end][start] = true;
                order[i].add(end);
            }
        }

        for (int i = 1; i <= N; i++) {
            // 아는 거 연쇄반응 시키기
            if (!know[i]) continue;
            bfs(i);
        }

        for (ArrayList<Integer> o : order) {
            boolean check = false;
            for (int i : o) {
                if (visited[i]) {
                    check = true;
                    break;
                }
            }

            if (!check) ans++;
        }

        System.out.println(ans);
        br.close();
    }

    public static void bfs(int start) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int num = q.poll();
            for (int i = 1; i <= N; i++) {
                if (visited[i] || !member[num][i] || num == i) continue;

                q.offer(i);
                visited[i] = true;
            }
        }
    }
}