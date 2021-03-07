package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10451_순열사이클 {

    static int N, cnt;
    static int[] list;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            cnt = 0;
            N = Integer.parseInt(br.readLine());
            visit = new boolean[N+1];
            list = new int[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if (!visit[i]) check(i);
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

    static void check(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;
        int temp = 0;
        while(!q.isEmpty()) {
            visit[temp] = true;
            temp = q.poll();
            if (visit[temp]) {
                if(temp == start) cnt++;
                return;
            }
            q.add(temp);
        }
    }
}
