package codingtest.kakao;

import java.util.ArrayList;

public class Kakao0403_3 {

    ArrayList<Integer>[] map;
    boolean[] visited;
    int end = 0, sum = Integer.MIN_VALUE;

    public int[] solution(int n, int[] passenger, int[][] train) {

        // 연결된 열차 저장
        map = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int[] stations : train) {
            int station1 = stations[0];
            int station2 = stations[1];

            if (map[station1] == null) map[station1] = new ArrayList<>();
            if (map[station2] == null) map[station2] = new ArrayList<>();

            map[station1].add(station2);
            map[station2].add(station1);
        }

        visited[1] = true;
        dfs(1, 0, passenger);

        return new int[]{end, sum};
    }

    public void dfs(int start, int total, int[] passenger) {
        boolean isEnd = true;
        // 연결된 노선 하나씩 열기
        for (int next : map[start]) {
            // 방문확인
            if (visited[next]) continue;

            // 방문안했으면 visit처리
            visited[next] = true;
            dfs(next, total + passenger[start - 1], passenger);
            visited[next] = false;

            // 다음 역이 있으면 false
            isEnd = false;
        }

        // 종착점이면 계산하기
        if (isEnd) {
            int result = total + passenger[start - 1];
            if (sum < result) {
                sum = result;
                end = start;
            } else if (sum == result) {
                end = Math.max(end, start);
            }
        }
    }
}
