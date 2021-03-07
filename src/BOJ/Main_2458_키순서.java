package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2458_키순서 {

    static int N, M, ans = 0;
    static ArrayList<Integer>[] upRelation;
    static ArrayList<Integer>[] downRelation;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        upRelation = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            upRelation[i] = new ArrayList<>();
        }
        downRelation = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            downRelation[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int low = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken());
            upRelation[low].add(high);
            downRelation[high].add(low);
        }

        for (int i = 1; i <= N; i++) {
            if (check(i)) ans++;
        }

        System.out.println(ans);
        br.close();
    }

    static boolean check(int student) {
        int cnt = 0;

        // 위로 찾기
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[N+1];
        q.add(student);
        visit[student] = true;
        while(!q.isEmpty()) {
            int poll = q.poll();
            for (int i = 0; i < upRelation[poll].size(); i++) {
                int up = upRelation[poll].get(i);
                if (visit[up]) continue;
                visit[up] = true;
                q.add(up);
                cnt++;
            }
        }

        // 아래로 찾기
        Arrays.fill(visit, false);
        q.clear();
        q.add(student);
        visit[student] = true;
        while(!q.isEmpty()) {
            int poll = q.poll();
            for (int i = 0; i < downRelation[poll].size(); i++) {
                int down = downRelation[poll].get(i);
                if (visit[down]) continue;
                visit[down] = true;
                q.add(down);
                cnt++;
            }
        }

        return cnt == N - 1;
    }
}
