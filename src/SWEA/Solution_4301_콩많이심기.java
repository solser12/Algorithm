package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_4301_콩많이심기 {

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 1;//Integer.parseInt(br.readLine());
        boolean[][] map;
        int[] d = {2, 0, -2, 0, 0, 2, 0, -2};

        for (int tc = 1; tc <= T; ++tc) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            map = new boolean[N][M];
            int cnt = N * M;

            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < M; ++j) {
                    if (!map[i][j]) {
                        for (int k = 0; k < d.length; k+=2) {
                            if (i+d[k] >= 0 && i+d[k] < N && j+d[k+1] >= 0 && j+d[k+1] < M && !map[i+d[k]][j+d[k+1]]) {
                                map[i+d[k]][j+d[k+1]] = true;
                                cnt--;
                            }
                        }
                    }
                }
            }
            //sb.append('#').append(tc).append(' ').append(cnt).append('\n');

            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < M; ++j) {
                    sb.append(map[i][j] ? '0' : '1').append('\t');
                }
                sb.append('\n');
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}