package BOJ;

import java.io.*;
import java.util.*;

public class Main_7562_나이트의이동 {

    static boolean[][] map;
    static int[] start = new int[2];
    static int[] dest = new int[2];
    static int I, cnt;
    static Queue<int[]> q;
    static int[] step = {-1, -2, -2, -1, -1, 2, -2, 1, 1, 2, 2, 1, 1, -2, 2, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; ++t) {

            q = new LinkedList<>();
            cnt = 0;
            I = Integer.parseInt(br.readLine());
            map = new boolean[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            dest[0] = Integer.parseInt(st.nextToken());
            dest[1] = Integer.parseInt(st.nextToken());

            q.add(start);
            map[start[0]][start[1]] = true;
            bfs();

            sb.append(cnt).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void bfs() {
        while(!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; ++s) {
                int[] temp = q.poll();
                if (temp[0] == dest[0] && temp[1] == dest[1]) return;
                for (int i = 0; i < step.length; i+=2) {
                    int x = temp[0] + step[i];
                    int y = temp[1] + step[i + 1];
                    if (x >= 0 && x < I && y >= 0 && y < I && !map[x][y]) {
                        map[x][y] = true;
                        q.add(new int[] {x, y});
                    }
                }
            }
            cnt++;
        }
    }
}
