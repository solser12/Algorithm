package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11725_트리의부모찾기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] nodes = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].add(b);
            nodes[b].add(a);
        }

        int[] ans = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.offer(1);
        while (!q.isEmpty()) {
            int parent = q.poll();
            for (int node : nodes[parent]) {
                if (visited[node]) {
                    continue;
                }

                ans[node] = parent;
                visited[node] = true;
                q.offer(node);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(ans[i]).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
