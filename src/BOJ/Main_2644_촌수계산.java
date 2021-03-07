package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2644_촌수계산 {

    static int N, start, end, ans = 1;
    static ArrayList<Integer>[] family;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 사람 수
        int N = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        family = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) family[i] = new ArrayList<>();

        // 촌수 계산 사람
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // 가족 관계
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            family[f1].add(f2);
            family[f2].add(f1);
        }

        if (!bfs()) ans = -1;

        System.out.println(ans);

        br.close();
    }

    static boolean bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;

        while(!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int temp = q.poll();
                for (int i = 0; i < family[temp].size(); i++) {
                    int fam = family[temp].get(i);
                    System.out.println(temp + " " + fam);
                    if (visit[fam]) continue;
                    if (end == fam) return true;
                    q.add(fam);
                    visit[fam] = true;
                }
            }
            ans++;
        }
        return false;
    }
}
