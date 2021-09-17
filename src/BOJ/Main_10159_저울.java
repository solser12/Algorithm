package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10159_저울 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[][] check = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            check[a][b] = true;
        }

        find(N, check);

        for (int i = 0; i < N; i++) {
            int cnt = N - 1;
            for (int j = 0; j < N; j++) {
                if (check[i][j] || check[j][i]) cnt--;
            }
            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static void find(int N, boolean[][] table) {

        for (int k = 0; k < N; k++) {           // 거쳐갈 노드
            for (int i = 0; i < N; i++) {       // 시작 노드
                for (int j = 0; j < N; j++) {   // 도착노드
                    if (table[i][k] && table[k][j]) {
                        table[i][j] = true;
                    }
                }
            }
        }
    }
}
