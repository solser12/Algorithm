package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1167_트리의지름 {

    static int N, ans = 0, second = 0;
    static ArrayList<Node>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            tree[start] = new ArrayList<>();

            while (true) {
                int end = Integer.parseInt(st.nextToken());
                if (end == -1) break;
                end--;
                int dist = Integer.parseInt(st.nextToken());
                tree[start].add(new Node(end, dist));
            }
        }

        visited = new boolean[N];
        visited[0] = true;
        dfs(0, 0);

        ans = 0;
        Arrays.fill(visited, false);
        visited[second] = true;
        dfs(second, 0);

        System.out.println(ans);
        br.close();
    }

    public static void dfs(int start, int sum) {

        boolean check = false;
        for (Node node : tree[start]) {
            if (visited[node.end]) continue;
            visited[node.end] = true;
            dfs(node.end, sum + node.dist);
            check = true;
        }

        if (!check) {
            if (ans < sum) {
                ans = sum;
                second = start;
            }
        }
    }

    public static class Node {
        int end, dist;

        public Node(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }
    }
}
