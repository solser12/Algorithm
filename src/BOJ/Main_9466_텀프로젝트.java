package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9466_텀프로젝트 {

    static int n;
    static int[] arr;
    static int[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            visited = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int input = Integer.parseInt(st.nextToken()) - 1;
                arr[i] = input;
            }

            find();
        }

        System.out.println(sb);
        br.close();
    }

    public static void find() {

        int ans = 0, cnt;
        for (int i = 0; i < n; i++) {

            if (visited[i] > 0) continue;

            cnt = 1;
            // 시작 인덱스
            int temp = i;
            visited[temp] = 1;
            // 끝 찾기
            while (true) {
                temp = arr[temp];
                // 이미 처리되어있으면 넘어가기
                if (visited[temp] > 0) break;
                // 방문 처리
                visited[temp] = 1;
                // 다음 인덱스
                cnt++;
            }

            // 아직 탐색중이면 회전 발생
            if (visited[temp] == 1) {
                // 회전 부분 팀 만들어주기
                while (visited[temp] != 3) {
                    visited[temp] = 3;
                    temp = arr[temp];
                    cnt--;
                }
            }

            temp = i;
            while (visited[temp] == 1) {
                visited[temp] = 2;
                temp = arr[temp];
            }
            ans += cnt;
        }

        sb.append(ans).append('\n');
    }
}
