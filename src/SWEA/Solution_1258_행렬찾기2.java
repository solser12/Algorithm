package SWEA;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_1258_행렬찾기2 {

    static  int[][] map;
    static int N, row, column;
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
                    if (map[i][j] > 0) {
                        row = 0; column = 0;
                        int x = i;
                        int y = j;
                        for (; x < N && map[x][j] != 0; ++x) row++;
                        for (; y < N && map[i][y] != 0; ++y) column++;
                        for (int m = i; m < x; ++m) {
                            for (int n = j; n < y; ++n) {
                                map[m][n] = 0;
                            }
                        }
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
