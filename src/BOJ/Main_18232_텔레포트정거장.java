package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18232_텔레포트정거장 {

    public static int n;
    public static ArrayList<Integer>[] teleport;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        teleport = new ArrayList[n + 1];

        for (int i = 2; i < n; i++) {
            teleport[i] = new ArrayList<>();
            teleport[i].add(i - 1);
            teleport[i].add(i + 1);
        }
        teleport[1] = new ArrayList<>();
        teleport[1].add(2);
        teleport[n] = new ArrayList<>();
        teleport[n].add(n - 1);

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            teleport[a].add(b);
            teleport[b].add(a);
        }

        System.out.println(bfs(s, e));
        br.close();
    }

    public static int bfs(int start, int end) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.offer(start);
        visited[start] = true;

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int now = q.poll();
                if (now == end) {
                    return time;
                }
                for (int i : teleport[now]) {
                    if (!visited[i]) {
                        visited[i] = true;
                        q.offer(i);
                    }
                }
            }
            time++;
        }

        return time;
    }
}
