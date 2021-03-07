package SWEA;

import java.io.*;
import java.util.*;

public class Solution_1258_행렬찾기 {

    static  int[][] map;
    static int N, row, column;
    static int[] d = {1, 0, -1, 0, 0, 1, 0, -1};
    static Queue<int[]> q;
    static ArrayList<Matrix> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; ++tc) {
            list = new ArrayList<>();
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; ++j) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    if (map[i][j] >= 1) {
                        row = 1; column = 1;
                        q = new LinkedList<>();
                        q.add(new int[] {i, j});
                        map[i][j] = -1;
                        bfs(i, j);
                        list.add(new Matrix(row, column, row*column));
                    }
                }
            }

            Collections.sort(list);

            sb.append('#').append(tc).append(' ').append(list.size()).append(' ');
            for (int i = 0; i < list.size(); ++i) {
                sb.append(list.get(i).row).append(' ').append(list.get(i).column).append(' ');
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static void bfs(int startx, int starty) {
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int i = 0; i < d.length; i+=2) {
                int dx = temp[0] + d[i];
                int dy = temp[1] + d[i+1];
                if (dx >= 0 && dx < N && dy >= 0 && dy < N && map[dx][dy] > 0) {
                    q.add(new int[] {dx, dy});
                    map[dx][dy] = -1;
                    if (dx == startx) column++;
                    else if (dy == starty) row++;
                }
            }
        }
    }

    static class Matrix implements Comparable<Matrix> {
        int row, column, size;

        Matrix (int r, int c, int s) {
            row = r;
            column = c;
            size = s;
        }

        @Override
        public int compareTo(Matrix m) {
            int result = Integer.compare(this.size, m.size);
            if (result != 0) return result;
            return this.row > m.row ? 1 : -1;
        }
    }
}
