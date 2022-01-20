package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1967_트리의지름 {

    public static int N, startNode = 0, maxWeight = Integer.MIN_VALUE;
    public static ArrayList<Next>[] table;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        table = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            table[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken()) - 1;
            int child = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());

            table[parent].add(new Next(child, weight));
            table[child].add(new Next(parent, weight));
        }

        visited[0] = true;
        find(0, 0);

        maxWeight = Integer.MIN_VALUE;
        Arrays.fill(visited, false);
        visited[startNode] = true;
        find(startNode, 0);

        System.out.println(maxWeight);
        br.close();
    }

    public static void find(int node, int sum) {

        if (maxWeight < sum) {
            startNode = node;
            maxWeight = sum;
        }

        for (Next next : table[node]) {
            if (visited[next.nextNode]) continue;
            visited[next.nextNode] = true;
            find(next.nextNode, sum + next.weight);
        }
    }

    public static class Next {
        int nextNode, weight;

        public Next(int nextNode, int weight) {
            this.nextNode = nextNode;
            this.weight = weight;
        }
    }
}
