package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12851_숨바꼭질2 {

    static int N, K, time = 0, cases = 0;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(time);
        System.out.println(cases);
        br.close();
    }

    static void bfs() {

        if (N == K) {
            cases++;
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        time++;

        while(!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int loc = q.poll();
                visited[loc] = true;
                for (int nextLoc : new int[] {loc + 1, loc - 1, loc * 2}) {
                    if (nextLoc >= 0 && nextLoc <= 100000) {
                        if (nextLoc == K) cases++;
                        if (!visited[nextLoc]) {
                            q.add(nextLoc);
                        }
                    }
                }
            }

            if (cases != 0) return;

            time++;
        }
    }

    static int next(int loc, int d) {
        int result = loc;

        switch (d) {
            case 0:
                result++;
                break;
            case 1:
                result--;
                break;
            case 2:
                result /= 2;
                break;
        }

        return result;
    }
}
