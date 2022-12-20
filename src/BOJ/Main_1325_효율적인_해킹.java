package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1325_효율적인_해킹 {

    public static int n, m;
    public static ArrayList<Integer>[] computers;
    public static int[] totalCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        totalCount = new int[n + 1];
        computers = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            computers[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            computers[a].add(b);
        }

        for (int i = 1; i <= n; i++) {
            bfs(i);
        }

        int max = 0;
        for (int i : totalCount) {
            max = Math.max(i, max);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (totalCount[i] == max) {
                sb.append(i).append(' ');
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static void bfs(int start) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.offer(start);
        visited[start] = true;
        totalCount[start]++;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int target : computers[now]) {
                if (!visited[target]) {
                    visited[target] = true;
                    q.offer(target);
                    totalCount[target]++;
                }
            }
        }
    }
}
