package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12761_돌다리 {

    public static int[] move = new int[6];
    public static int n, m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        move[0] = 1;
        move[1] = -1;
        move[2] = Integer.parseInt(st.nextToken());
        move[3] = Integer.parseInt(st.nextToken());
        move[4] = -move[2];
        move[5] = -move[3];
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
        br.close();
    }

    public static int bfs() {

        int result = 0;
        int[] stone = new int[100001];
        Arrays.fill(stone, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        stone[n] = 0;

        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int now = q.poll();
                if (now == m) {
                    result = stone[now];
                    break;
                }

                for (int i = 0; i < 6; i++) {
                    int dm = now + move[i];
                    if (check(dm) && stone[dm] > step) {
                        stone[dm] = step;
                        q.offer(dm);
                    }
                }

                for (int i = 2; i < 4; i++) {
                    int dm = now * move[i];
                    if (check(dm) && stone[dm] > step) {
                        stone[dm] = step;
                        q.offer(dm);
                    }
                }
            }
            step++;
        }

        return result;
    }

    public static boolean check(int loc) {
        return 0 <= loc && loc <= 100000;
    }
}
