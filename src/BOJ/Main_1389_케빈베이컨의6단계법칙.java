package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1389_케빈베이컨의6단계법칙 {

    static int N, M;
    static ArrayList<Integer>[] list;
    static int[][] save;
    static int ans = Integer.MAX_VALUE;
    static int person = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        save = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            list[f1].add(f2);
            list[f2].add(f1);
        }

        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        System.out.println(person);
        br.close();
    }

    static void bfs(int start) {
        int cnt = 0, jump = 1;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[N+1];
        q.add(start);
        visit[start] = true;

        while(!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int next = q.poll();
                for (int i = 0; i < list[next].size(); i++) {
                    int f = list[next].get(i);
                    if (visit[f]) continue;
                    visit[f] = true;
                    q.add(f);
                    cnt += jump;
//                    save[start][f] = jump;
//                    save[f][start] = jump;
                }
            }
            jump++;
        }

        if (ans > cnt) {
            person = start;
            ans = cnt;
        }
    }
}
