package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471_게리맨더링 {

    static int N, ans = Integer.MAX_VALUE;
    static int[] popul;
    static boolean[] visit;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        popul = new int[N+1];
        visit = new boolean[N+1];
        list = new ArrayList[N+1];

        for (int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < popul.length; i++) {
            popul[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            while(st.hasMoreTokens()) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        powerSet(1);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
        br.close();
    }

    static void powerSet(int cnt) {
        if (cnt == N+1) {
            checking();
            return;
        }
        visit[cnt] = true;
        powerSet(cnt+1);
        visit[cnt] = false;
        powerSet(cnt+1);

    }

    static void checking() {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        boolean[] visit1 = new boolean[N+1];
        boolean[] visit2 = new boolean[N+1];

        for (int i = 1; i < visit.length; i++) {
            if (visit[i]) {
                list1.add(i);
                visit2[i] = true;
            }
            else {
                list2.add(i);
                visit1[i] = true;
            }
        }
        if (list1.size() == 0 || list2.size() == 0) return;

        int sum1 = 0, sum2 = 0;

        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(list1.get(0));
        visit1[list1.get(0)] = true;
        sum1 += popul[list1.get(0)];
        while(!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 0; i < list[temp].size(); i++) {
                if (visit1[list[temp].get(i)]) continue;
                visit1[list[temp].get(i)] = true;
                sum1+= popul[list[temp].get(i)];
                q.add(list[temp].get(i));
                cnt++;
            }
            if (cnt == list1.size()) break;
        }
        if (cnt != list1.size()) return;

        cnt = 1;
        q = new LinkedList<>();
        q.add(list2.get(0));
        visit2[list2.get(0)] = true;
        sum2 += popul[list2.get(0)];
        while(!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 0; i < list[temp].size(); i++) {
                if (visit2[list[temp].get(i)]) continue;
                visit2[list[temp].get(i)] = true;
                sum2+= popul[list[temp].get(i)];
                q.add(list[temp].get(i));
                cnt++;
            }
            if (cnt == list2.size()) break;
        }
        if (cnt != list2.size()) return;

        ans = Math.min(ans, Math.abs(sum1 - sum2));
    }
}
