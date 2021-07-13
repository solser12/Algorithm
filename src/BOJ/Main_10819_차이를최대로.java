package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10819_차이를최대로 {

    static int N, ans = 0;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            check(0, 0, i);
            visited[i] = false;
        }

        System.out.println(ans);

        br.close();
    }

    static void check(int cnt, int sum, int next) {
        if (cnt == N - 1) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            check(cnt + 1, sum + Math.abs(arr[next] - arr[i]), i);
            visited[i] = false;
        }
    }
}
