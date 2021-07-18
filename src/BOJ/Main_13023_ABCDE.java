package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13023_ABCDE {

    static int N, M;
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];

        list = new ArrayList[N];
        for (int i = 0; i < N; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited, false);
            visited[i] = true;
            check(i, 0);
        }

        System.out.println(0);
        br.close();
    }

    static void check(int num, int depth) {

        if (depth == 4) {
            System.out.println(1);
            System.exit(0);
        }

        for (int i : list[num]) {

            if (visited[i]) continue;

            visited[i] = true;
            check(i, depth + 1);
            visited[i] = false;
        }
    }
}
