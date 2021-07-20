package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1005_ACMCraft {

    static int N, K, W;
    static int[] buildTime;
    static ArrayList<Integer>[] next;
    static int[] visited;
    static int[] count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());   // 건물 갯수
            K = Integer.parseInt(st.nextToken());   // 규칙 갯수
            buildTime = new int[N + 1];
            count = new int[N + 1];

            visited = new int[N + 1];
            Arrays.fill(visited, 0);

            next = new ArrayList[N + 1];
            for (int i = 1; i < N + 1; i++) {
                next[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                buildTime[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                next[a].add(b);
                count[b]++;
            }

            W = Integer.parseInt(br.readLine());

            sb.append(check()).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static int check() {

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (count[i] == 0) {
                q.add(i);
                visited[i] = buildTime[i];
            }
        }

        while (!q.isEmpty()) {
            int poll = q.poll();

            for (int i : next[poll]) {
                if (visited[i] < visited[poll] + buildTime[i]) {
                    visited[i] = visited[poll] + buildTime[i];
                }

                count[i]--;
                if (count[i] == 0) {
                    q.add(i);
                }
            }
        }

        return visited[W];
    }
}
