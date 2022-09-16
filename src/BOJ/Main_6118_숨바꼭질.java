package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_6118_숨바꼭질 {

    public static int n, m;
    public static ArrayList<Integer>[] barn;
    public static int num, count = 0, dist = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        barn = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            barn[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            barn[a].add(b);
            barn[b].add(a);
        }

        bfs();

        System.out.println(num + " " + dist + " " + count);
        br.close();
    }

    public static void bfs() {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.offer(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            dist++;
            int size = q.size();
            count = q.size();
            num = Integer.MAX_VALUE;
            for (int s = 0; s < size; s++) {
                int temp = q.poll();
                num = Math.min(num, temp);
                for (int i : barn[temp]) {
                    if (!visited[i]) {
                        visited[i] = true;
                        q.offer(i);
                    }
                }
            }
        }
    }
}
