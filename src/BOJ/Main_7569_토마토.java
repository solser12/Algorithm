package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main_7569_토마토 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] map = new int [h][m][n];
        int[] check = {1, 0 , 0, -1, 0, 0, 0, 0, 1, 0, 0, -1, 0, 1, 0, 0, -1, 0};
        Queue<int[]> q = new LinkedList<>();
        int ngrow = 0;

        for (int k = 0; k < h; ++k) {
            for (int i = 0; i < m; ++i) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; ++j) {
                    map[k][i][j] = Integer.parseInt(st.nextToken());
                    if (map[k][i][j] == 1) {
                        q.add(new int[] {k, i, j});
                    }
                    else if (map[k][i][j] == 0) ngrow++;
                }
            }
        }

        int day = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int[] temp = q.poll();
                for (int j = 0; j < check.length; j+=3) {
                    int th = temp[0] + check[j];
                    int tm = temp[1] + check[j+1];
                    int tn = temp[2] + check[j+2];

                    if (th < 0 || th >= h || tm < 0 || tm >= m || tn < 0 || tn >= n) continue;
                    if (map[th][tm][tn] == -1 || map[th][tm][tn] == 1)
                        continue;
                    q.add(new int[] {th, tm, tn});
                    map[th][tm][tn] = 1;
                    ngrow--;
                }
            }
            day++;
        }

        System.out.print(ngrow == 0 ? day-1 : -1);
    }
}
