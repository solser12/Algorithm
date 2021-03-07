package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main_7576_토마토 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int [m][n];
        int[] check = {1, 0 , -1, 0, 0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();
        int ngrow = 0;

        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.add(new int[] {i, j});
                }
                else if (map[i][j] == 0) ngrow++;
            }
        }

        int day = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int[] temp = q.poll();
                for (int j = 0; j < check.length; j+=2) {
                    int tm = temp[0] + check[j];
                    int tn = temp[1] + check[j+1];

                    if (tm < 0 || tm >= m || tn < 0 || tn >= n) continue;
                    if (map[tm][tn] == -1 || map[tm][tn] == 1)
                        continue;
                    q.add(new int[] {tm, tn});
                    map[tm][tn] = 1;
                    ngrow--;
                }
            }
            day++;
        }

        System.out.print(ngrow == 0 ? day-1 : -1);
    }
}
