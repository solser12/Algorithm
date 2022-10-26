package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10709_기상캐스터 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        Queue<Cloud> q = new LinkedList<>();
        int[][] sky = new int[H][W];
        for (int i = 0; i < H; i++) {
            String input = br.readLine();
            for (int j = 0; j < W; j++) {
                char c = input.charAt(j);
                if (c == 'c') {
                    q.offer(new Cloud(i, j));
                }
                sky[i][j] = -1;
            }
        }

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Cloud cloud = q.poll();
                if (sky[cloud.x][cloud.y] == -1) {
                    sky[cloud.x][cloud.y] = time;
                    if (cloud.y < W - 1) {
                        cloud.move();
                        q.offer(cloud);
                    }
                }
            }
            time++;
        }

        StringBuilder sb = new StringBuilder();
        for (int[] ints : sky) {
            for (int i : ints) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
        br.close();
    }

    public static class Cloud {

        int x, y;

        public Cloud(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move() {
            y++;
        }
    }
}
