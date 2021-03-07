package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2583_영역구하기 {

    static int N, M, K;
    static boolean[][] paper;
    static int cnt = 0;
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] d = {0, 1, 0 , -1, 1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        paper = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            for (int m = x1; m < x2; m++) {
                for (int n = y1; n < y2; n++) {
                    paper[m][n] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!paper[i][j]) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }

        Collections.sort(list);

        sb.append(cnt).append('\n');
        for (int i : list) {
            sb.append(i).append(' ');
        }
        sb.append('\n');

        System.out.println(sb.toString());
        br.close();
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        int size = 1;
        q.add(new int[]{x, y});
        paper[x][y] = true;

        while(!q.isEmpty()) {
            int[] temp = q.poll();
            for (int i = 0; i < d.length; i+=2) {
                int dx = temp[0] + d[i];
                int dy = temp[1] + d[i+1];
                if (dx >= 0 && dx < N && dy >= 0 && dy < M && !paper[dx][dy]) {
                    size++;
                    paper[dx][dy] = true;
                    q.add(new int[] {dx, dy});
                }
            }
        }
        list.add(size);
    }
}
