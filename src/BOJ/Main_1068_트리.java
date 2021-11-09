package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1068_트리 {

    static int N, start, del, ans = 0;
    static ArrayList<Integer>[] table;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        table = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            table[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num == -1) start = i;
            else table[num].add(i);

            parent[i] = num;
        }

        del = Integer.parseInt(br.readLine());

        if (del != start) {
            table[parent[del]].remove(Integer.valueOf(del));
//            dfs(start);
            bfs();
        }

        System.out.println(ans);
        br.close();
    }

    public static void bfs() {

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int poll = q.poll();

            if (table[poll].isEmpty()) {
                ans++;
            } else {
                for (int i : table[poll]) {
                    q.offer(i);
                }
            }
        }
    }

//    public static void dfs(int node) {
//
//        if (table[node].size() == 0) {
//            ans++;
//            return;
//        }
//
//        for (int i : table[node]) {
//            dfs(i);
//        }
//    }
}
