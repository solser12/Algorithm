package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5014_스타트링크 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int ans = bfs(F, S, G, U, D);
        if (ans == -1) System.out.println("use the stairs");
        else System.out.println(ans);

        br.close();
    }

    public static int bfs(int F, int S, int G, int U, int D) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[F + 1];
        visited[S] = true;
        q.offer(S);

        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int floor = q.poll();
                if (floor == G) {
                    return cnt;
                }

                int next = floor + U;
                if (next <= F && !visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }

                next = floor - D;
                if (next > 0 && !visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
            cnt++;
        }

        return -1;
    }
}
