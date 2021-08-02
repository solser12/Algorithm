package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11404_플로이드 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        final int INF = 100000000;

        int N = Integer.parseInt(br.readLine());
        int[][] table = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(table[i], INF);
            table[i][i] = 0;
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            table[a][b] = Math.min(table[a][b], c);
        }

        // 플로이드 와샬
        for (int k = 0; k < N; k++) {           // 거쳐갈 노드
            for (int i = 0; i < N; i++) {       // 시작 노드
                if (k == i) continue;
                for (int j = 0; j < N; j++) {   // 도착 노ㄷ
                    int temp = table[i][k] + table[k][j];
                    table[i][j] = Math.min(table[i][j], temp);
                }
            }
        }


        for (int[] ints : table) {
            for (int i : ints) {
                sb.append(i == INF ? 0 : i).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
