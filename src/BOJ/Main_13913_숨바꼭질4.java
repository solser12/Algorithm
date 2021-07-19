package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13913_숨바꼭질4 {

    static int N, K;
    static int[] visited = new int[100001];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            sb.append(0).append('\n').append(N);
            System.out.println(sb);
        } else if (N > K) {
            sb.append(N - K).append('\n');
            for (int i = N; i >= K; i--) {
                sb.append(i).append(' ');
            }
            System.out.println(sb);
        } else {
            Arrays.fill(visited, -1);
            bfs();
            print();
        }

        br.close();
    }

    public static void bfs() {

        Queue<Integer> q = new LinkedList<>();
        q.add(K);
        visited[K] = Integer.MAX_VALUE;

        int  time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int poll = q.poll();

                if (poll == N) {
                    System.out.println(time);
                    return;
                }

                int move = poll + 1;
                if (move <= 100000 && visited[move] == -1) {
                    visited[move] = poll;
                    q.add(move);
                }

                move = poll - 1;
                if (move >= 0 && visited[move] == -1) {
                    visited[move] = poll;
                    q.add(move);
                }

                if (poll % 2 != 0) continue;

                move = poll / 2;
                if (visited[move] == -1) {
                    visited[move] = poll;
                    q.add(move);
                }
            }
            time++;
        }
    }

    public static void print() {

        int temp = N;

        while (temp != Integer.MAX_VALUE) {
            sb.append(temp).append(' ');
            temp = visited[temp];
        }

        System.out.println(sb);
    }
}
