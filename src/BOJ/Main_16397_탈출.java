package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16397_탈출 {

    static final int INF = 100000;
    static int N, T, G;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());

        int ans = bfs();
        System.out.println(ans != -1 ? ans : "ANG");

        br.close();
    }

    public static int bfs() {

        boolean[] visited = new boolean[INF];
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = true;

        int time = 0;
        while (!q.isEmpty() && time <= T) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int poll = q.poll();
                if (poll == G) return time;

                // A
                int num = poll + 1;
                if (num < INF && !visited[num]) {
                    visited[num] = true;
                    q.add(num);
                }

                // B
                num = poll << 1;
                if (num < INF) {
                    num = remove(num);
                    if (!visited[num]) {
                        visited[num] = true;
                        q.add(num);
                    }
                }
            }
            time++;
        }

        return -1;
    }

    public static int remove(int num) {
        int result = num;

        if (result == 0) return result;
        if (num < 10) result -= 1;
        else if (num < 100) result -= 10;
        else if (num < 1000) result -= 100;
        else if (num < 10000) result -= 1000;
        else result -= 10000;

        return result;
    }
}
