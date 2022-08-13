package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5567_결혼식 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        LinkedList<Integer>[] friends = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            friends[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            friends[a].add(b);
            friends[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        q.offer(0);
        int ans = 0;
        for (int i = 0; !q.isEmpty() && i < 2; i++) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int now = q.poll();
                for (int f : friends[now]) {
                    if (!visited[f]) {
                        visited[f] = true;
                        q.offer(f);
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
        br.close();
    }
}
