package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15649_N과M1 {

    static int N, M;
    static boolean[] visit;
    static ArrayList<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1];

        perm(0);

        System.out.println(sb.toString());

        br.close();
    }

    static void perm(int cnt) {
        if (cnt == M) {
            for (int i : list) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i < N + 1; i++) {
            if (!visit[i]) {
                list.add(i);
                visit[i] = true;
                perm(cnt + 1);
                list.remove(list.size()-1);
                visit[i] = false;
            }
        }
    }
}
