package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14248_점프점프 {

    public static int n;
    public static int[] stoneBridge;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        stoneBridge = new int[n];
        for (int i = 0; i < n; i++) {
            stoneBridge[i] = Integer.parseInt(st.nextToken());
        }
        int start = Integer.parseInt(br.readLine()) - 1;

        System.out.println(bfs(start));
        br.close();
    }

    public static int bfs(int start) {

        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = -1; i <= 1; i += 2) {
                int loc = now + stoneBridge[now] * i;
                if (0 <= loc && loc < n && !visited[loc]) {
                    visited[loc] = true;
                    q.offer(loc);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
