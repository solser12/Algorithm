package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16940_BFS스페셜저지 {

    static ArrayList<Integer>[] table;
    static int N;
    static int[] list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        table = new ArrayList[N];
        list = new int[N];

        for (int i = 0; i < N; i++) {
            table[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            table[start].add(end);
            table[end].add(start);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken()) - 1;
            list[num] = i;
        }

        System.out.println(bfs());
        br.close();
    }

    public static int bfs() {

        boolean[] visited = new boolean[N];
        Queue<Integer> q = new LinkedList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited[0] = true;
        q.offer(0);

        int idx = 0;
        while (!q.isEmpty()) {
            int num = q.poll();
            if (list[num] != idx) {
                return 0;
            }

            for (int i : table[num]) {
                if (visited[i]) continue;
                visited[i] = true;
                pq.add(new Node(i));
            }

            while (!pq.isEmpty()) {
                q.offer(pq.poll().num);
            }

            idx++;
        }

        return 1;
    }

    public static class Node implements Comparable<Node> {
        int num;

        public Node(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Node o) {
            return list[this.num] - list[o.num];
        }
    }
}
