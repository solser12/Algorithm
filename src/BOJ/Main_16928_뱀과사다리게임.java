package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16928_뱀과사다리게임 {

    static int N, M, ans = 0;
    static int[] move = new int[101];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            move[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        bfs();

        System.out.println(ans);
        br.close();
    }

    public static void bfs() {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[101];
        q.add(1);
        visited[1] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int num = q.poll();
                if (num == 100) {
                    ans = cnt;
                    return;
                }

                for (int i = 1; i <= 6; i++) {
                    int dice = num + i;

                    if (dice > 100) continue;

                    if (move[dice] != 0) {
                        dice = move[dice];
                    }

                    if (!visited[dice]) {
                        visited[dice] = true;
                        q.add(dice);
                    }
                }
            }
            cnt++;
        }
    }
}
