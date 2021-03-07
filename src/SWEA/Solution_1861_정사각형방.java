package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Solution_1861_정사각형방 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};
        int T = Integer.parseInt(br.readLine());
        int[][] loc;
        int cnt, start = 0, result = 0, step;
        int temp;

        for (int tc = 1; tc <= T; ++tc) {
            int N = Integer.parseInt(br.readLine());
            cnt = 0; step = 0;
            loc = new int[2][N*N];

            for (int i = 0; i < N; ++i) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; ++j) {
                    temp = Integer.parseInt(st.nextToken());
                    loc[0][temp-1] = i;
                    loc[1][temp-1] = j;
                }
            }

            for (int i = 0; i < N*N-1; ++i) {
                for (int j = 0; j < 4; ++j) {
                    if (loc[0][i] + di[j] == loc[0][i+1] && loc[1][i] + dj[j] == loc[1][i+1]) {
                        if (cnt == 0) start = i+1;
                        cnt++;
                        if ( i != N*N-2) break;
                    }
                    if (j == 3) {
                        if (step-1 < cnt) {
                            result = start;
                            step = cnt+1;
                        }
                        cnt = 0;
                    }
                }
            }

            sb.append('#').append(tc).append(' ').append(result).append(' ').append(step).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
