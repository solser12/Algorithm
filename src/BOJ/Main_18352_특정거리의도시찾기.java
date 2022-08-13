package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_18352_특정거리의도시찾기 {

    public static int n, m, k, x;
    public static ArrayList<Integer>[] road;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        road = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            road[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            road[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        for (int i : bfs()) {
            sb.append(i).append('\n');
        }

        System.out.print(sb);
        br.close();
    }

    public static int[] bfs() {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[x] = true;
        q.offer(x);
        int dist = 0;

        while (dist != k && !q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int now = q.poll();
                for (int r : road[now]) {
                    if (!visited[r]) {
                        visited[r] = true;
                        q.offer(r);
                    }
                }
            }
            dist++;
        }

        int[] ans;
        if (q.isEmpty()) {
            ans = new int[] {-1};
        } else {
            ans = new int[q.size()];
            int index = 0;
            while (!q.isEmpty()) {
                ans[index++] = q.poll();
            }
            Arrays.sort(ans);
        }

        return ans;
    }
}
