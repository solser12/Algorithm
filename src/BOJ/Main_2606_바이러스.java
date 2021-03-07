package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main_2606_바이러스 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int computer = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] list = new ArrayList[computer+1];
        boolean[] visit = new boolean[computer+1];

        for (int i = 0; i <= computer; ++i) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < num; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        q.add(1);
        visit[1] = true;

        while (!q.isEmpty()) {
            int data = q.poll();
            for (int j = 0; j < list[data].size(); ++j) {
                int temp = list[data].get(j);
                if (visit[temp]) continue;
                visit[temp] = true;
                q.add(temp);
                cnt++;
            }

        }

        System.out.print(cnt);

        br.close();
    }
}
