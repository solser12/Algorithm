package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15591_MooTube {

    static int N, Q;
    static ArrayList<Video>[] list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Video(b, c));
            list[b].add(new Video(a, c));
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken()) - 1;
            sb.append(bfs(k, v)).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static int bfs(int k, int v) {

        boolean[] visited = new boolean[N];
        Queue<Video> q = new LinkedList<>();
        q.offer(new Video(v, Integer.MAX_VALUE));
        visited[v] = true;

        int ans = 0;

        while (!q.isEmpty()) {
            Video video = q.poll();

            for (Video temp : list[video.num]) {
                if (visited[temp.num]) continue;

                Video offer = new Video(temp.num, Math.min(temp.usado, video.usado));
                visited[offer.num] = true;
                q.add(offer);
                if (offer.usado >= k) ans++;
            }
        }

        return ans;
    }

    public static class Video {
        int num, usado;

        public Video(int num, int usado) {
            this.num = num;
            this.usado = usado;
        }
    }
}
