package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15664_N과M10 {

    static int N, M, len = 0;
    static int[] list, print;
    static boolean[] visit;
    static ArrayList<int[]> result = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[N];
        print = new int[M];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        perm(0,0);

        for (int[] temp : result) {
            for (int i = 0; i < M; ++i) sb.append(temp[i]).append(' ');
            sb.append('\n');
        }

        System.out.print(sb);
        br.close();
    }

    static void perm(int start, int cnt) {

        if (cnt == M) {
            for (int i = 0; i < result.size(); ++i) {
                int[] temp = result.get(i);
                for (int j = 0; j < M; ++j) {
                    if (temp[j] != print[j]) break;
                    if (j == M -1) return;
                }
            }
            result.add(print.clone());
            return;
        }

        for (int i = start; i < N; ++i) {
            if (!visit[i]) {
                visit[i] = true;
                print[len++] = list[i];
                perm(i + 1, cnt + 1);
                len--;
                visit[i] = false;
            }
        }
    }
}
