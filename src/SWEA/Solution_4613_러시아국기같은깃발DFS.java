package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4613_러시아국기같은깃발DFS {

    static int N, M;
    static int[] wlist, blist, rlist;
    static int result;

    public static void main(String[] args) throws IOException {

        //DFS
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            wlist = new int[N];
            blist = new int[N];
            rlist = new int[N];
            result = Integer.MAX_VALUE;

            for (int n = 0; n < N; n++) {
                char[] input = br.readLine().toCharArray();
                for (int i = 0; i < M; i++) {
                    if (input[i] == 'W') { rlist[n]++; blist[n]++; }
                    else if (input[i] =='B') { wlist[n]++; rlist[n]++; }
                    else if (input[i] == 'R') { wlist[n]++; blist[n]++; }
                }
            }

            dfs(1, 0, wlist[0]);
            sb.append('#').append(t).append(' ').append(result).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

    static void dfs(int cnt, int color, int sum) {
        if (cnt == N) {
            if (color == 2) result = Math.min(result, sum);
            return;
        }

        if (color == 0) {
            dfs(cnt+1, color, sum + wlist[cnt]);
            dfs(cnt+1, color+1, sum + blist[cnt]);
        }
        else if (color == 1) {
            dfs(cnt+1, color, sum + blist[cnt]);
            dfs(cnt+1, color+1, sum + rlist[cnt]);
        }
        else if (color == 2) {
            dfs(cnt+1, color, sum + rlist[cnt]);
        }
    }
}