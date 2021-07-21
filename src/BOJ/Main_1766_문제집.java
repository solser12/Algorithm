package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1766_문제집 {

    static int N, M;
    static ArrayList<Integer>[] arr;
    static int[] cnt;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) arr[i] = new ArrayList<>();

        cnt = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cnt[b]++;
            arr[a].add(b);
        }

        solve();

        br.close();
    }

    public static void solve() {

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < N + 1; i++) {
            if (cnt[i] == 0) {
                pq.add(i);
                visited[i] = true;
            }
        }

        while (!pq.isEmpty()) {

            int q = pq.poll();

            sb.append(q).append(' ');

            for (int i : arr[q]) {
                cnt[i]--;
                if (cnt[i] == 0 && !visited[i]) {
                    pq.add(i);
                    visited[i] = true;
                }
            }
        }

        System.out.println(sb);
    }
}
