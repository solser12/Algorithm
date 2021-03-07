package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11724_연결요소의개수 {

    static int N, M, result = 0;
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for (int i = 0; i <= N; ++i) {
            list[i] = new ArrayList<>();
        }

        visit = new boolean[N+1];

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }

        for (int i = 1; i <= N; ++i) {
            if (!visit[i]) {
                q.add(i);
                visit[i] = true;
                bfs();
                result++;
            }
        }

        System.out.println(result);
        br.close();
    }

    static void bfs() {
        while(!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 0; i < list[temp].size(); ++i) {
                int loc = list[temp].get(i);
                if (!visit[loc]) {
                    q.add(loc);
                    visit[loc] = true;
                }
            }
        }
    }
}
