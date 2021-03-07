package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2667_단지번호붙이기 {

    static int[][] map;
    static Queue<int[]> q = new LinkedList<>();
    static int[] d = {0, 1, 0, -1, 1, 0, -1, 0};
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; ++i) {
            String input = br.readLine();
            for (int j = 0; j < N; ++j) {
                map[i][j] = (int)input.charAt(j) - 48;
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (map[i][j] == 1) {
                    list.add(bfs(i, j));
                    cnt++;
                }
            }
        }
        list.sort(null);
        sb.append(cnt).append('\n');
        for (int i =0; i < list.size(); ++i) {
            sb.append(list.get(i)).append('\n');
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    public static int bfs(int m, int n) {
        int apart = 1;
        q.add(new int[] {m, n});
        map[m][n] = 2;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int i = 0; i < d.length; i+=2) {
                int dx = temp[0] + d[i];
                int dy = temp[1] + d[i+1];
                if (dx >= 0 && dx < N && dy >= 0 && dy < N && map[dx][dy] == 1) {
                    q.add(new int[] {dx, dy});
                    map[dx][dy] = 2;
                    apart++;
                }
            }
        }
        return apart;
    }
}
