package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1922_네트워크연결_Prim {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        LinkedList<Edge>[] list = new LinkedList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new LinkedList<>();
        }

        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[from].add(new Edge(to, cost));
            list[to].add(new Edge(from, cost));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));

        int cnt = 0;
        int ans = 0;
        while(cnt != N) {
            Edge e = pq.poll();
            if (visited[e.to]) continue;
            visited[e.to] = true;
            while(!list[e.to].isEmpty()) {
                Edge edge = list[e.to].poll();
                if (!visited[edge.to]) {
                    pq.add(edge);
                }
            }
            cnt++;
            ans += e.cost;
        }

        System.out.println(ans);
        br.close();

    }

    public static class Edge implements Comparable<Edge> {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
