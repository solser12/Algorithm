package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18513_샘터 {

    static long ans = 0;
    static int N, K;
    static boolean[] map = new boolean[200200001];  // 100000000이 0
    static int MAX_INDEX = 200200000;
    static int MIN_INDEX = 0;
    static int ZERO_INDEX = 100100000;
    static int[] dt = {1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
            
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        bfs(st);

        System.out.println(ans);
        br.close();
    }

    static void bfs(StringTokenizer st) {

        int houseCnt = 0; // 집 카운트

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            // 샘터 위치, 샘터 위치 true
            int temp = Integer.parseInt(st.nextToken()) + ZERO_INDEX;
            map[temp] = true;
            q.add(temp);
        }

        int dist = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int loc = q.poll();
                for (int d = 0; d < 2; d++) {
                    int dx = loc + dt[d];
                    if (dx > MAX_INDEX || dx < MIN_INDEX || map[dx]) continue;
                    q.add(dx);
                    map[dx] = true;
                    ans += dist;
                    houseCnt++;
                    if (houseCnt == K) return;
                }
            }
            dist++;
        }
    }
}