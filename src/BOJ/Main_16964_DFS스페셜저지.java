package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16964_DFS스페셜저지 {

    static int N, idx = -1;
    static ArrayList<Integer>[] table;
    static int[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new int[N];
        visited = new boolean[N];
        table = new ArrayList[N];
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

        visited[0] = true;
        dfs(0);

        System.out.println(1);
        br.close();
    }

    public static void dfs(int num) {

        idx++;
        if (list[num] != idx) {
            System.out.println(0);
            System.exit(0);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i : table[num]) {
            if (visited[i]) continue;
            visited[i] = true;
            pq.offer(new Node(i));
        }

        while (!pq.isEmpty()) {
            dfs(pq.poll().num);
        }
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
